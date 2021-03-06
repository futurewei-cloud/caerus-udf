#!/bin/sh
set -o errexit

# create registry container unless it already exists
reg_name='kind-registry'
reg_port='5000'
running="$(docker inspect -f '{{.State.Running}}' "${reg_name}" 2>/dev/null || true)"
if [ "${running}" != 'true' ]; then
  docker run \
    -d --rm -e REGISTRY_STORAGE_DELETE_ENABLED=true -p "${reg_port}:5000" --name "${reg_name}" \
    registry:2.7
  docker run -d --rm --network host\
   -p 8086:80 \
   --name=docker_registry_ui \
   -e REGISTRY_HOST=localhost \
   -e REGISTRY_PORT=5000 \
   -e REGISTRY_PROTOCOL=http \
   -e SSL_VERIFY=false \
   -e USERNAME=admin \
   -e PASSWORD=mypassword \
   parabuzzle/craneoperator:latest
fi

# create a cluster with the local registry enabled in containerd
cat <<EOF | kind create cluster --config=-
kind: Cluster
apiVersion: kind.x-k8s.io/v1alpha4
containerdConfigPatches:
- |-
  [plugins."io.containerd.grpc.v1.cri".registry.mirrors."localhost:${reg_port}"]
    endpoint = ["http://${reg_name}:${reg_port}"]
EOF

# connect the registry to the cluster network
docker network connect "kind" "${reg_name}"

# tell https://tilt.dev to use the registry
# https://docs.tilt.dev/choosing_clusters.html#discovering-the-registry
for node in $(kind get nodes); do
  kubectl annotate node "${node}" "kind.x-k8s.io/registry=localhost:${reg_port}";
done

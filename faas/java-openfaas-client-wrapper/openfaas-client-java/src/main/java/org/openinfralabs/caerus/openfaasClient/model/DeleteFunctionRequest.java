/*
 * OpenFaaS API Gateway
 * OpenFaaS API documentation
 *
 * OpenAPI spec version: 0.8.12
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package org.openinfralabs.caerus.openfaasClient.model;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;

/**
 * DeleteFunctionRequest
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-09-06T06:46:10.176+02:00")
public class DeleteFunctionRequest {
  @SerializedName("functionName")
  private String functionName = null;

  public DeleteFunctionRequest functionName(String functionName) {
    this.functionName = functionName;
    return this;
  }

   /**
   * Name of deployed function
   * @return functionName
  **/
  @ApiModelProperty(example = "nodeinfo", required = true, value = "Name of deployed function")
  public String getFunctionName() {
    return functionName;
  }

  public void setFunctionName(String functionName) {
    this.functionName = functionName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeleteFunctionRequest deleteFunctionRequest = (DeleteFunctionRequest) o;
    return Objects.equals(this.functionName, deleteFunctionRequest.functionName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(functionName);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeleteFunctionRequest {\n");
    
    sb.append("    functionName: ").append(toIndentedString(functionName)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}


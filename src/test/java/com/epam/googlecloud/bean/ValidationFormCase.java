package com.epam.googlecloud.bean;

import java.util.Objects;

public class ValidationFormCase {

    private String VMClass;
    private String instanceType;
    private String region;
    private String totalAvailableLocalSSDSpace;
    private String commitmentTerm;
    private String totalEstimatedCost;

    public ValidationFormCase(String VMClass, String instanceType, String region, String totalAvailableLocalSSDSpace, String commitmentTerm, String totalEstimationCost) {
        this.VMClass = VMClass;
        this.instanceType = instanceType;
        this.region = region;
        this.totalAvailableLocalSSDSpace = totalAvailableLocalSSDSpace;
        this.commitmentTerm = commitmentTerm;
        this.totalEstimatedCost = totalEstimationCost;
    }

    public String getVMClass() {
        return VMClass;
    }

    public void setVMClass(String VMClass) {
        this.VMClass = VMClass;
    }

    public String getInstanceType() {
        return instanceType;
    }

    public void setInstanceType(String instanceType) {
        this.instanceType = instanceType;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getTotalAvailableLocalSSDSpace() {
        return totalAvailableLocalSSDSpace;
    }

    public void setTotalAvailableLocalSSDSpace(String totalAvailableLocalSSDSpace) {
        this.totalAvailableLocalSSDSpace = totalAvailableLocalSSDSpace;
    }

    public String getCommitmentTerm() {
        return commitmentTerm;
    }

    public void setCommitmentTerm(String commitmentTerm) {
        this.commitmentTerm = commitmentTerm;
    }

    public String getTotalEstimatedCost() {
        return totalEstimatedCost;
    }

    public void setTotalEstimatedCost(String totalEstimatedCost) {
        this.totalEstimatedCost = totalEstimatedCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ValidationFormCase that = (ValidationFormCase) o;
        return Objects.equals(VMClass, that.VMClass) &&
                Objects.equals(instanceType, that.instanceType) &&
                Objects.equals(region, that.region) &&
                Objects.equals(totalAvailableLocalSSDSpace, that.totalAvailableLocalSSDSpace) &&
                Objects.equals(commitmentTerm, that.commitmentTerm) &&
                Objects.equals(totalEstimatedCost, that.totalEstimatedCost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(VMClass, instanceType, region, totalAvailableLocalSSDSpace, commitmentTerm, totalEstimatedCost);
    }

    @Override
    public String toString() {
        return "ValidationFormCase{" +
                "VMClass='" + VMClass + '\'' +
                ", instanceType='" + instanceType + '\'' +
                ", region='" + region + '\'' +
                ", totalAvailableLocalSSDSpace='" + totalAvailableLocalSSDSpace + '\'' +
                ", commitmentTerm='" + commitmentTerm + '\'' +
                ", totalEstimatedCost='" + totalEstimatedCost + '\'' +
                '}';
    }
}

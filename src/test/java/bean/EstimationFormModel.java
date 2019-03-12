package bean;

import java.util.Objects;

public class EstimationFormModel {
    private String numberOfInstances;
    private String operatingSystemAndSoftware;
    private String VMClass;
    private String instanceType;
    private String addGPU;
    private String numberOfGPUs;
    private String GPUType;
    private String localSSD;
    private String dataCenterLocation;
    private String commitmentTerm;
    private String totalEstimationCost;

    
    public EstimationFormModel(String numberOfInstances,
                               String operatingSystemAndSoftware,
                               String VMClass,
                               String instanceType,
                               String addGPU,
                               String numberOfGPUs,
                               String GPUType,
                               String localSSD,
                               String dataCenterLocation,
                               String commitmentTerm) {
        this.numberOfInstances = numberOfInstances;
        this.operatingSystemAndSoftware = operatingSystemAndSoftware;
        this.VMClass = VMClass;
        this.instanceType = instanceType;
        this.addGPU = addGPU;
        this.numberOfGPUs = numberOfGPUs;
        this.GPUType = GPUType;
        this.localSSD = localSSD;
        this.dataCenterLocation = dataCenterLocation;
        this.commitmentTerm = commitmentTerm;
    }

    public String getNumberOfInstances() {
        return numberOfInstances;
    }

    public void setNumberOfInstances(String numberOfInstances) {
        this.numberOfInstances = numberOfInstances;
    }

    public String getOperatingSystemAndSoftware() {
        return operatingSystemAndSoftware;
    }

    public void setOperatingSystemAndSoftware(String operatingSystemAndSoftware) {
        this.operatingSystemAndSoftware = operatingSystemAndSoftware;
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

    public String getAddGPU() {
        return addGPU;
    }

    public void setAddGPU(String addGPU) {
        this.addGPU = addGPU;
    }

    public String getNumberOfGPUs() {
        return numberOfGPUs;
    }

    public void setNumberOfGPUs(String numberOfGPUs) {
        this.numberOfGPUs = numberOfGPUs;
    }

    public String getGPUType() {
        return GPUType;
    }

    public void setGPUType(String GPUType) {
        this.GPUType = GPUType;
    }

    public String getLocalSSD() {
        return localSSD;
    }

    public void setLocalSSD(String localSSD) {
        this.localSSD = localSSD;
    }

    public String getDataCenterLocation() {
        return dataCenterLocation;
    }

    public void setDataCenterLocation(String dataCenterLocation) {
        this.dataCenterLocation = dataCenterLocation;
    }

    public String getCommitmentTerm() {
        return commitmentTerm;
    }

    public void setCommitmentTerm(String commitmentTerm) {
        this.commitmentTerm = commitmentTerm;
    }

    public String getTotalEstimatedCost() {
        return totalEstimationCost;
    }

    public void setTotalEstimatedCost(String totalEstimationCost) {
        this.totalEstimationCost = totalEstimationCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstimationFormModel that = (EstimationFormModel) o;
        return Objects.equals(numberOfInstances, that.numberOfInstances) &&
                Objects.equals(operatingSystemAndSoftware, that.operatingSystemAndSoftware) &&
                Objects.equals(VMClass, that.VMClass) &&
                Objects.equals(instanceType, that.instanceType) &&
                Objects.equals(addGPU, that.addGPU) &&
                Objects.equals(numberOfGPUs, that.numberOfGPUs) &&
                Objects.equals(GPUType, that.GPUType) &&
                Objects.equals(localSSD, that.localSSD) &&
                Objects.equals(dataCenterLocation, that.dataCenterLocation) &&
                Objects.equals(commitmentTerm, that.commitmentTerm) &&
                Objects.equals(totalEstimationCost, that.totalEstimationCost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfInstances, operatingSystemAndSoftware, VMClass, instanceType, addGPU, numberOfGPUs, GPUType, localSSD, dataCenterLocation, commitmentTerm, totalEstimationCost);
    }

    @Override
    public String toString() {
        return "EstimationFormModel{" +
                "numberOfInstances='" + numberOfInstances + '\'' +
                ", operatingSystemAndSoftware='" + operatingSystemAndSoftware + '\'' +
                ", VMClass='" + VMClass + '\'' +
                ", instanceType='" + instanceType + '\'' +
                ", addGPU='" + addGPU + '\'' +
                ", numberOfGPUs='" + numberOfGPUs + '\'' +
                ", GPUType='" + GPUType + '\'' +
                ", localSSD='" + localSSD + '\'' +
                ", dataCenterLocation='" + dataCenterLocation + '\'' +
                ", commitmentTerm='" + commitmentTerm + '\'' +
                ", totalEstimationCost='" + totalEstimationCost + '\'' +
                '}';
    }
}

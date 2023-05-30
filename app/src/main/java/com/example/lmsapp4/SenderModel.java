package com.example.lmsapp4;

public class SenderModel {

    String name;
    String indexNo;
    String activityType;
    String degreeType;
    String batchesName;
    String moduleNam;
    String stuMarks;

    public SenderModel(String name, String indexNo, String activityType, String degreeType, String batchesName, String moduleNam, String stuMarks) {
        this.name = name;
        this.indexNo = indexNo;
        this.activityType = activityType;
        this.degreeType = degreeType;
        this.batchesName = batchesName;
        this.moduleNam = moduleNam;
        this.stuMarks = stuMarks;
    }

    public SenderModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIndexNo() {
        return indexNo;
    }

    public void setIndexNo(String indexNo) {
        this.indexNo = indexNo;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public String getDegreeType() {
        return degreeType;
    }

    public void setDegreeType(String degreeType) {
        this.degreeType = degreeType;
    }

    public String getBatchesName() {
        return batchesName;
    }

    public void setBatchesName(String batchesName) {
        this.batchesName = batchesName;
    }

    public String getModuleNam() {
        return moduleNam;
    }

    public void setModuleNam(String moduleNam) {
        this.moduleNam = moduleNam;
    }

    public String getStuMarks() {
        return stuMarks;
    }

    public void setStuMarks(String stuMarks) {
        this.stuMarks = stuMarks;
    }
}

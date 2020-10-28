package com.hclg.hc_confirm_order.pojo;

public class EnterStudyRegister {
    private Integer id;
    private String projectName;
    private String name;
    private String workYear;
    private String education;
    private String profession;
    private String require;
    private String target;
    private String confuse;
    private String expect;
    private String nickName;

    @Override
    public String toString() {
        return "EnterStudyRegister{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
                ", name='" + name + '\'' +
                ", workYear='" + workYear + '\'' +
                ", education='" + education + '\'' +
                ", profession='" + profession + '\'' +
                ", require='" + require + '\'' +
                ", target='" + target + '\'' +
                ", confuse='" + confuse + '\'' +
                ", expect='" + expect + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWorkYear() {
        return workYear;
    }

    public void setWorkYear(String workYear) {
        this.workYear = workYear;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getRequire() {
        return require;
    }

    public void setRequire(String require) {
        this.require = require;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getConfuse() {
        return confuse;
    }

    public void setConfuse(String confuse) {
        this.confuse = confuse;
    }

    public String getExpect() {
        return expect;
    }

    public void setExpect(String expect) {
        this.expect = expect;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}

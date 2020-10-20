package com.unis.common_module.bean;

import java.util.List;

public class AccountinfoBean {

    /**
     * baseInfo : {"id":"1000000000000914004","createTime":"2020-09-27 11:17:25","creator":"1000000000001268846","updateTime":"2020-10-14 14:14:44","modificator":"1000000000001268846","account":"qys_cs","userName":"戚同学","pinyin":"qi tongxue","delFlag":0,"datacenterUserPassword":null,"passwordEncryptMethod":"bcrypt","mobile":"18900000000","email":"2405414082@qq.com","userPhoto":"https://uniedutest.oss-cn-north-2.unicloudsrv.com/2020/10/12/16f5166c1c31218657a2549e49579e16.jpg","forbidden":0,"lockFlag":0,"lockTime":null,"salt":null,"lastLoginTime":null,"isModifiedPassword":0,"source":null,"invalidateTime":null}
     * extInfo : {"id":"1000000000000914004","createTime":"2020-09-27 11:17:25","creator":"1000000000001268846","updateTime":"2020-10-14 14:14:44","modificator":"1000000000001268846","englishName":null,"gender":null,"genderCode":null,"birthDate":null,"usedName":null,"remark":null,"idCardNo":"370832199803197310","idCardType":null,"idCardTypeCode":null,"pinyinName":null,"userNormalPhoto":null,"nation":null,"nationCode":null,"politicalState":null,"politicalStateCode":null,"source":null,"nationality":null,"nativePlace":null,"nativeCode":null,"birthPlace":null,"birthPlaceCode":null,"hongKongKiu":null,"censusRegister":null,"censusRegisterDetail":null,"censusNature":null,"liveAddr":null,"zipCode":null,"postalAddr":null,"politicalTime":null,"homeTel":null,"homeAddr":null,"allergicHistory":null,"medicalHistory":null,"bloodType":null,"healthGrade":null,"eduId":null,"nationalityCode":null,"censusAreaCode":null,"maritalStatusCode":null,"hongKongKiuCode":null,"healthGradeCode":null,"bloodTypeCode":null,"fax":null,"disabledTypeCode":null}
     * account : {"id":"1000100000000790003","createTime":null,"creator":null,"updateTime":null,"modificator":null,"userId":"1000000000000914004","accountType":"TEACHER","accountTypeDesc":"普通教职工","accountStatus":1,"accountOrder":0,"isMain":true,"schoolId":"1000000000000589179","schoolType":null,"eduId":null,"staffNo":null,"childAccountId":null,"phaseId":null,"schoolName":"紫光摩信","invalidDate":null,"invalidStatus":0,"sourceDic":null,"source":null,"account":null}
     * teacher : {"id":"1000100000000790003","createTime":"2020-09-27 11:17:25","creator":"1000000000001268846","updateTime":"2020-10-14 14:14:44","modificator":"1000000000001268846","userId":"1000000000000914004","schoolId":"1000000000000589179","teacherCertificate":null,"majorSubject":null,"professionalTitle":null,"professionalTitleDate":null,"majorPhase":null,"majorGrade":null,"job":null,"teacherStaffNo":null,"pinyin":null,"departmentList":[{"id":"1000000000003411190","departmentName":"摩信部门2","userOrdernoInDepartment":7,"isPartTime":0},{"id":"1000000000003411191","departmentName":"摩信部门3","userOrdernoInDepartment":5,"isPartTime":1},{"id":"1000000000003411189","departmentName":"摩信部门1","userOrdernoInDepartment":6,"isPartTime":1},{"id":"1000000000003411216","departmentName":"摩信部门1子部门","userOrdernoInDepartment":7,"isPartTime":1}],"highestEduDegree":null,"highestMajor":null,"highestCertificate":null,"highestEduSystem":null,"highestGraduate":null,"highestGraduateTime":null,"certificateType":null,"certificateNum":null,"foreignLanguageType":null,"foreignLanguageLevel":null,"employedDate":null,"isPayroll":"","mandarinLevel":null,"mandarinLevelTime":null,"mandarinCertificateNo":null,"teachYears":null,"individualResume":null,"teachBeginTime":null,"subjectBackground":null,"entryDate":null,"employBeginDate":null,"originalEduDegree":null,"originalMajor":null,"originalEduSystem":null,"originalGraduate":null,"originalGraduateTime":null,"officeTel":null,"actualPostLevel":null,"wagesJob":null,"professionalPostType":null,"isFullTime":"0","keyTeacherLevel":null,"keyTeacherTime":null,"schoolYears":null,"uninterruptedStanding":null,"professionalCertificate":null,"professionalCertificateTime":null,"isChurchMeans":"0","isCampFamily":"0","spokenEnglishLevel":null,"spokenEnglishTime":null,"spokenEnglishCertificateNo":null,"computerLevel":null,"computerLevelTime":null,"computerCertificateNo":null,"teacherCertificateType":null,"identity":null,"teachingGroup":null,"visitedCountry":null,"postType":null,"deputyPostType":null,"dimissionReason":null,"professionTechnicalPost":null,"partTimeJob":null,"teacherSource":null,"mandarinLevelCode":null,"highestEduDegreeCode":null,"highestEduDegreeGraduate":null,"highestCertificateCode":null,"highestCertificateGraduate":null,"teacherCertificateTypeCode":null,"jobCode":null,"professionTechnicalPostCode":null,"postTypeCode":null,"postLevelCode":null,"officeStatus":null,"employEndDate":null}
     * student : null
     * parent : null
     * accountRoleList : [{"id":"teacher","createTime":null,"creator":null,"updateTime":null,"modificator":null,"roleName":"普通教职工","roleCode":null,"remark":null,"appId":null,"roleType":null,"autoGrant":null,"systemRole":null,"usertype":null,"areaScope":null,"orderno":null,"positionLevel":null,"schoolId":null,"endTime":null,"dataScope":null,"schoolName":null,"defaultFlag":false,"accountId":null}]
     * canOperationFlag : false
     * sourceCode : null
     * operations : null
     */

    private BaseInfoBean baseInfo;
    private ExtInfoBean extInfo;
    private AccountBean account;
    private TeacherBean teacher;
    private Object student;
    private Object parent;
    private boolean canOperationFlag;
    private Object sourceCode;
    private Object operations;
    private List<AccountRoleListBean> accountRoleList;

    public BaseInfoBean getBaseInfo() {
        return baseInfo;
    }

    public void setBaseInfo(BaseInfoBean baseInfo) {
        this.baseInfo = baseInfo;
    }

    public ExtInfoBean getExtInfo() {
        return extInfo;
    }

    public void setExtInfo(ExtInfoBean extInfo) {
        this.extInfo = extInfo;
    }

    public AccountBean getAccount() {
        return account;
    }

    public void setAccount(AccountBean account) {
        this.account = account;
    }

    public TeacherBean getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherBean teacher) {
        this.teacher = teacher;
    }

    public Object getStudent() {
        return student;
    }

    public void setStudent(Object student) {
        this.student = student;
    }

    public Object getParent() {
        return parent;
    }

    public void setParent(Object parent) {
        this.parent = parent;
    }

    public boolean isCanOperationFlag() {
        return canOperationFlag;
    }

    public void setCanOperationFlag(boolean canOperationFlag) {
        this.canOperationFlag = canOperationFlag;
    }

    public Object getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(Object sourceCode) {
        this.sourceCode = sourceCode;
    }

    public Object getOperations() {
        return operations;
    }

    public void setOperations(Object operations) {
        this.operations = operations;
    }

    public List<AccountRoleListBean> getAccountRoleList() {
        return accountRoleList;
    }

    public void setAccountRoleList(List<AccountRoleListBean> accountRoleList) {
        this.accountRoleList = accountRoleList;
    }

    public static class BaseInfoBean {
        /**
         * id : 1000000000000914004
         * createTime : 2020-09-27 11:17:25
         * creator : 1000000000001268846
         * updateTime : 2020-10-14 14:14:44
         * modificator : 1000000000001268846
         * account : qys_cs
         * userName : 戚同学
         * pinyin : qi tongxue
         * delFlag : 0
         * datacenterUserPassword : null
         * passwordEncryptMethod : bcrypt
         * mobile : 18900000000
         * email : 2405414082@qq.com
         * userPhoto : https://uniedutest.oss-cn-north-2.unicloudsrv.com/2020/10/12/16f5166c1c31218657a2549e49579e16.jpg
         * forbidden : 0
         * lockFlag : 0
         * lockTime : null
         * salt : null
         * lastLoginTime : null
         * isModifiedPassword : 0
         * source : null
         * invalidateTime : null
         */

        private String id;
        private String createTime;
        private String creator;
        private String updateTime;
        private String modificator;
        private String account;
        private String userName;
        private String pinyin;
        private int delFlag;
        private Object datacenterUserPassword;
        private String passwordEncryptMethod;
        private String mobile;
        private String email;
        private String userPhoto;
        private int forbidden;
        private int lockFlag;
        private Object lockTime;
        private Object salt;
        private Object lastLoginTime;
        private int isModifiedPassword;
        private Object source;
        private Object invalidateTime;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getCreator() {
            return creator;
        }

        public void setCreator(String creator) {
            this.creator = creator;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public String getModificator() {
            return modificator;
        }

        public void setModificator(String modificator) {
            this.modificator = modificator;
        }

        public String getAccount() {
            return account;
        }

        public void setAccount(String account) {
            this.account = account;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getPinyin() {
            return pinyin;
        }

        public void setPinyin(String pinyin) {
            this.pinyin = pinyin;
        }

        public int getDelFlag() {
            return delFlag;
        }

        public void setDelFlag(int delFlag) {
            this.delFlag = delFlag;
        }

        public Object getDatacenterUserPassword() {
            return datacenterUserPassword;
        }

        public void setDatacenterUserPassword(Object datacenterUserPassword) {
            this.datacenterUserPassword = datacenterUserPassword;
        }

        public String getPasswordEncryptMethod() {
            return passwordEncryptMethod;
        }

        public void setPasswordEncryptMethod(String passwordEncryptMethod) {
            this.passwordEncryptMethod = passwordEncryptMethod;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getUserPhoto() {
            return userPhoto;
        }

        public void setUserPhoto(String userPhoto) {
            this.userPhoto = userPhoto;
        }

        public int getForbidden() {
            return forbidden;
        }

        public void setForbidden(int forbidden) {
            this.forbidden = forbidden;
        }

        public int getLockFlag() {
            return lockFlag;
        }

        public void setLockFlag(int lockFlag) {
            this.lockFlag = lockFlag;
        }

        public Object getLockTime() {
            return lockTime;
        }

        public void setLockTime(Object lockTime) {
            this.lockTime = lockTime;
        }

        public Object getSalt() {
            return salt;
        }

        public void setSalt(Object salt) {
            this.salt = salt;
        }

        public Object getLastLoginTime() {
            return lastLoginTime;
        }

        public void setLastLoginTime(Object lastLoginTime) {
            this.lastLoginTime = lastLoginTime;
        }

        public int getIsModifiedPassword() {
            return isModifiedPassword;
        }

        public void setIsModifiedPassword(int isModifiedPassword) {
            this.isModifiedPassword = isModifiedPassword;
        }

        public Object getSource() {
            return source;
        }

        public void setSource(Object source) {
            this.source = source;
        }

        public Object getInvalidateTime() {
            return invalidateTime;
        }

        public void setInvalidateTime(Object invalidateTime) {
            this.invalidateTime = invalidateTime;
        }
    }

    public static class ExtInfoBean {
        /**
         * id : 1000000000000914004
         * createTime : 2020-09-27 11:17:25
         * creator : 1000000000001268846
         * updateTime : 2020-10-14 14:14:44
         * modificator : 1000000000001268846
         * englishName : null
         * gender : null
         * genderCode : null
         * birthDate : null
         * usedName : null
         * remark : null
         * idCardNo : 370832199803197310
         * idCardType : null
         * idCardTypeCode : null
         * pinyinName : null
         * userNormalPhoto : null
         * nation : null
         * nationCode : null
         * politicalState : null
         * politicalStateCode : null
         * source : null
         * nationality : null
         * nativePlace : null
         * nativeCode : null
         * birthPlace : null
         * birthPlaceCode : null
         * hongKongKiu : null
         * censusRegister : null
         * censusRegisterDetail : null
         * censusNature : null
         * liveAddr : null
         * zipCode : null
         * postalAddr : null
         * politicalTime : null
         * homeTel : null
         * homeAddr : null
         * allergicHistory : null
         * medicalHistory : null
         * bloodType : null
         * healthGrade : null
         * eduId : null
         * nationalityCode : null
         * censusAreaCode : null
         * maritalStatusCode : null
         * hongKongKiuCode : null
         * healthGradeCode : null
         * bloodTypeCode : null
         * fax : null
         * disabledTypeCode : null
         */

        private String id;
        private String createTime;
        private String creator;
        private String updateTime;
        private String modificator;
        private Object englishName;
        private Object gender;
        private Object genderCode;
        private Object birthDate;
        private Object usedName;
        private Object remark;
        private String idCardNo;
        private Object idCardType;
        private Object idCardTypeCode;
        private Object pinyinName;
        private Object userNormalPhoto;
        private Object nation;
        private Object nationCode;
        private Object politicalState;
        private Object politicalStateCode;
        private Object source;
        private Object nationality;
        private Object nativePlace;
        private Object nativeCode;
        private Object birthPlace;
        private Object birthPlaceCode;
        private Object hongKongKiu;
        private Object censusRegister;
        private Object censusRegisterDetail;
        private Object censusNature;
        private Object liveAddr;
        private Object zipCode;
        private Object postalAddr;
        private Object politicalTime;
        private Object homeTel;
        private Object homeAddr;
        private Object allergicHistory;
        private Object medicalHistory;
        private Object bloodType;
        private Object healthGrade;
        private Object eduId;
        private Object nationalityCode;
        private Object censusAreaCode;
        private Object maritalStatusCode;
        private Object hongKongKiuCode;
        private Object healthGradeCode;
        private Object bloodTypeCode;
        private Object fax;
        private Object disabledTypeCode;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getCreator() {
            return creator;
        }

        public void setCreator(String creator) {
            this.creator = creator;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public String getModificator() {
            return modificator;
        }

        public void setModificator(String modificator) {
            this.modificator = modificator;
        }

        public Object getEnglishName() {
            return englishName;
        }

        public void setEnglishName(Object englishName) {
            this.englishName = englishName;
        }

        public Object getGender() {
            return gender;
        }

        public void setGender(Object gender) {
            this.gender = gender;
        }

        public Object getGenderCode() {
            return genderCode;
        }

        public void setGenderCode(Object genderCode) {
            this.genderCode = genderCode;
        }

        public Object getBirthDate() {
            return birthDate;
        }

        public void setBirthDate(Object birthDate) {
            this.birthDate = birthDate;
        }

        public Object getUsedName() {
            return usedName;
        }

        public void setUsedName(Object usedName) {
            this.usedName = usedName;
        }

        public Object getRemark() {
            return remark;
        }

        public void setRemark(Object remark) {
            this.remark = remark;
        }

        public String getIdCardNo() {
            return idCardNo;
        }

        public void setIdCardNo(String idCardNo) {
            this.idCardNo = idCardNo;
        }

        public Object getIdCardType() {
            return idCardType;
        }

        public void setIdCardType(Object idCardType) {
            this.idCardType = idCardType;
        }

        public Object getIdCardTypeCode() {
            return idCardTypeCode;
        }

        public void setIdCardTypeCode(Object idCardTypeCode) {
            this.idCardTypeCode = idCardTypeCode;
        }

        public Object getPinyinName() {
            return pinyinName;
        }

        public void setPinyinName(Object pinyinName) {
            this.pinyinName = pinyinName;
        }

        public Object getUserNormalPhoto() {
            return userNormalPhoto;
        }

        public void setUserNormalPhoto(Object userNormalPhoto) {
            this.userNormalPhoto = userNormalPhoto;
        }

        public Object getNation() {
            return nation;
        }

        public void setNation(Object nation) {
            this.nation = nation;
        }

        public Object getNationCode() {
            return nationCode;
        }

        public void setNationCode(Object nationCode) {
            this.nationCode = nationCode;
        }

        public Object getPoliticalState() {
            return politicalState;
        }

        public void setPoliticalState(Object politicalState) {
            this.politicalState = politicalState;
        }

        public Object getPoliticalStateCode() {
            return politicalStateCode;
        }

        public void setPoliticalStateCode(Object politicalStateCode) {
            this.politicalStateCode = politicalStateCode;
        }

        public Object getSource() {
            return source;
        }

        public void setSource(Object source) {
            this.source = source;
        }

        public Object getNationality() {
            return nationality;
        }

        public void setNationality(Object nationality) {
            this.nationality = nationality;
        }

        public Object getNativePlace() {
            return nativePlace;
        }

        public void setNativePlace(Object nativePlace) {
            this.nativePlace = nativePlace;
        }

        public Object getNativeCode() {
            return nativeCode;
        }

        public void setNativeCode(Object nativeCode) {
            this.nativeCode = nativeCode;
        }

        public Object getBirthPlace() {
            return birthPlace;
        }

        public void setBirthPlace(Object birthPlace) {
            this.birthPlace = birthPlace;
        }

        public Object getBirthPlaceCode() {
            return birthPlaceCode;
        }

        public void setBirthPlaceCode(Object birthPlaceCode) {
            this.birthPlaceCode = birthPlaceCode;
        }

        public Object getHongKongKiu() {
            return hongKongKiu;
        }

        public void setHongKongKiu(Object hongKongKiu) {
            this.hongKongKiu = hongKongKiu;
        }

        public Object getCensusRegister() {
            return censusRegister;
        }

        public void setCensusRegister(Object censusRegister) {
            this.censusRegister = censusRegister;
        }

        public Object getCensusRegisterDetail() {
            return censusRegisterDetail;
        }

        public void setCensusRegisterDetail(Object censusRegisterDetail) {
            this.censusRegisterDetail = censusRegisterDetail;
        }

        public Object getCensusNature() {
            return censusNature;
        }

        public void setCensusNature(Object censusNature) {
            this.censusNature = censusNature;
        }

        public Object getLiveAddr() {
            return liveAddr;
        }

        public void setLiveAddr(Object liveAddr) {
            this.liveAddr = liveAddr;
        }

        public Object getZipCode() {
            return zipCode;
        }

        public void setZipCode(Object zipCode) {
            this.zipCode = zipCode;
        }

        public Object getPostalAddr() {
            return postalAddr;
        }

        public void setPostalAddr(Object postalAddr) {
            this.postalAddr = postalAddr;
        }

        public Object getPoliticalTime() {
            return politicalTime;
        }

        public void setPoliticalTime(Object politicalTime) {
            this.politicalTime = politicalTime;
        }

        public Object getHomeTel() {
            return homeTel;
        }

        public void setHomeTel(Object homeTel) {
            this.homeTel = homeTel;
        }

        public Object getHomeAddr() {
            return homeAddr;
        }

        public void setHomeAddr(Object homeAddr) {
            this.homeAddr = homeAddr;
        }

        public Object getAllergicHistory() {
            return allergicHistory;
        }

        public void setAllergicHistory(Object allergicHistory) {
            this.allergicHistory = allergicHistory;
        }

        public Object getMedicalHistory() {
            return medicalHistory;
        }

        public void setMedicalHistory(Object medicalHistory) {
            this.medicalHistory = medicalHistory;
        }

        public Object getBloodType() {
            return bloodType;
        }

        public void setBloodType(Object bloodType) {
            this.bloodType = bloodType;
        }

        public Object getHealthGrade() {
            return healthGrade;
        }

        public void setHealthGrade(Object healthGrade) {
            this.healthGrade = healthGrade;
        }

        public Object getEduId() {
            return eduId;
        }

        public void setEduId(Object eduId) {
            this.eduId = eduId;
        }

        public Object getNationalityCode() {
            return nationalityCode;
        }

        public void setNationalityCode(Object nationalityCode) {
            this.nationalityCode = nationalityCode;
        }

        public Object getCensusAreaCode() {
            return censusAreaCode;
        }

        public void setCensusAreaCode(Object censusAreaCode) {
            this.censusAreaCode = censusAreaCode;
        }

        public Object getMaritalStatusCode() {
            return maritalStatusCode;
        }

        public void setMaritalStatusCode(Object maritalStatusCode) {
            this.maritalStatusCode = maritalStatusCode;
        }

        public Object getHongKongKiuCode() {
            return hongKongKiuCode;
        }

        public void setHongKongKiuCode(Object hongKongKiuCode) {
            this.hongKongKiuCode = hongKongKiuCode;
        }

        public Object getHealthGradeCode() {
            return healthGradeCode;
        }

        public void setHealthGradeCode(Object healthGradeCode) {
            this.healthGradeCode = healthGradeCode;
        }

        public Object getBloodTypeCode() {
            return bloodTypeCode;
        }

        public void setBloodTypeCode(Object bloodTypeCode) {
            this.bloodTypeCode = bloodTypeCode;
        }

        public Object getFax() {
            return fax;
        }

        public void setFax(Object fax) {
            this.fax = fax;
        }

        public Object getDisabledTypeCode() {
            return disabledTypeCode;
        }

        public void setDisabledTypeCode(Object disabledTypeCode) {
            this.disabledTypeCode = disabledTypeCode;
        }
    }

    public static class AccountBean {
        /**
         * id : 1000100000000790003
         * createTime : null
         * creator : null
         * updateTime : null
         * modificator : null
         * userId : 1000000000000914004
         * accountType : TEACHER
         * accountTypeDesc : 普通教职工
         * accountStatus : 1
         * accountOrder : 0
         * isMain : true
         * schoolId : 1000000000000589179
         * schoolType : null
         * eduId : null
         * staffNo : null
         * childAccountId : null
         * phaseId : null
         * schoolName : 紫光摩信
         * invalidDate : null
         * invalidStatus : 0
         * sourceDic : null
         * source : null
         * account : null
         */

        private String id;
        private Object createTime;
        private Object creator;
        private Object updateTime;
        private Object modificator;
        private String userId;
        private String accountType;
        private String accountTypeDesc;
        private int accountStatus;
        private int accountOrder;
        private boolean isMain;
        private String schoolId;
        private Object schoolType;
        private Object eduId;
        private Object staffNo;
        private Object childAccountId;
        private Object phaseId;
        private String schoolName;
        private Object invalidDate;
        private int invalidStatus;
        private Object sourceDic;
        private Object source;
        private Object account;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Object getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Object createTime) {
            this.createTime = createTime;
        }

        public Object getCreator() {
            return creator;
        }

        public void setCreator(Object creator) {
            this.creator = creator;
        }

        public Object getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Object updateTime) {
            this.updateTime = updateTime;
        }

        public Object getModificator() {
            return modificator;
        }

        public void setModificator(Object modificator) {
            this.modificator = modificator;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getAccountType() {
            return accountType;
        }

        public void setAccountType(String accountType) {
            this.accountType = accountType;
        }

        public String getAccountTypeDesc() {
            return accountTypeDesc;
        }

        public void setAccountTypeDesc(String accountTypeDesc) {
            this.accountTypeDesc = accountTypeDesc;
        }

        public int getAccountStatus() {
            return accountStatus;
        }

        public void setAccountStatus(int accountStatus) {
            this.accountStatus = accountStatus;
        }

        public int getAccountOrder() {
            return accountOrder;
        }

        public void setAccountOrder(int accountOrder) {
            this.accountOrder = accountOrder;
        }

        public boolean isIsMain() {
            return isMain;
        }

        public void setIsMain(boolean isMain) {
            this.isMain = isMain;
        }

        public String getSchoolId() {
            return schoolId;
        }

        public void setSchoolId(String schoolId) {
            this.schoolId = schoolId;
        }

        public Object getSchoolType() {
            return schoolType;
        }

        public void setSchoolType(Object schoolType) {
            this.schoolType = schoolType;
        }

        public Object getEduId() {
            return eduId;
        }

        public void setEduId(Object eduId) {
            this.eduId = eduId;
        }

        public Object getStaffNo() {
            return staffNo;
        }

        public void setStaffNo(Object staffNo) {
            this.staffNo = staffNo;
        }

        public Object getChildAccountId() {
            return childAccountId;
        }

        public void setChildAccountId(Object childAccountId) {
            this.childAccountId = childAccountId;
        }

        public Object getPhaseId() {
            return phaseId;
        }

        public void setPhaseId(Object phaseId) {
            this.phaseId = phaseId;
        }

        public String getSchoolName() {
            return schoolName;
        }

        public void setSchoolName(String schoolName) {
            this.schoolName = schoolName;
        }

        public Object getInvalidDate() {
            return invalidDate;
        }

        public void setInvalidDate(Object invalidDate) {
            this.invalidDate = invalidDate;
        }

        public int getInvalidStatus() {
            return invalidStatus;
        }

        public void setInvalidStatus(int invalidStatus) {
            this.invalidStatus = invalidStatus;
        }

        public Object getSourceDic() {
            return sourceDic;
        }

        public void setSourceDic(Object sourceDic) {
            this.sourceDic = sourceDic;
        }

        public Object getSource() {
            return source;
        }

        public void setSource(Object source) {
            this.source = source;
        }

        public Object getAccount() {
            return account;
        }

        public void setAccount(Object account) {
            this.account = account;
        }
    }

    public static class TeacherBean {
        /**
         * id : 1000100000000790003
         * createTime : 2020-09-27 11:17:25
         * creator : 1000000000001268846
         * updateTime : 2020-10-14 14:14:44
         * modificator : 1000000000001268846
         * userId : 1000000000000914004
         * schoolId : 1000000000000589179
         * teacherCertificate : null
         * majorSubject : null
         * professionalTitle : null
         * professionalTitleDate : null
         * majorPhase : null
         * majorGrade : null
         * job : null
         * teacherStaffNo : null
         * pinyin : null
         * departmentList : [{"id":"1000000000003411190","departmentName":"摩信部门2","userOrdernoInDepartment":7,"isPartTime":0},{"id":"1000000000003411191","departmentName":"摩信部门3","userOrdernoInDepartment":5,"isPartTime":1},{"id":"1000000000003411189","departmentName":"摩信部门1","userOrdernoInDepartment":6,"isPartTime":1},{"id":"1000000000003411216","departmentName":"摩信部门1子部门","userOrdernoInDepartment":7,"isPartTime":1}]
         * highestEduDegree : null
         * highestMajor : null
         * highestCertificate : null
         * highestEduSystem : null
         * highestGraduate : null
         * highestGraduateTime : null
         * certificateType : null
         * certificateNum : null
         * foreignLanguageType : null
         * foreignLanguageLevel : null
         * employedDate : null
         * isPayroll :
         * mandarinLevel : null
         * mandarinLevelTime : null
         * mandarinCertificateNo : null
         * teachYears : null
         * individualResume : null
         * teachBeginTime : null
         * subjectBackground : null
         * entryDate : null
         * employBeginDate : null
         * originalEduDegree : null
         * originalMajor : null
         * originalEduSystem : null
         * originalGraduate : null
         * originalGraduateTime : null
         * officeTel : null
         * actualPostLevel : null
         * wagesJob : null
         * professionalPostType : null
         * isFullTime : 0
         * keyTeacherLevel : null
         * keyTeacherTime : null
         * schoolYears : null
         * uninterruptedStanding : null
         * professionalCertificate : null
         * professionalCertificateTime : null
         * isChurchMeans : 0
         * isCampFamily : 0
         * spokenEnglishLevel : null
         * spokenEnglishTime : null
         * spokenEnglishCertificateNo : null
         * computerLevel : null
         * computerLevelTime : null
         * computerCertificateNo : null
         * teacherCertificateType : null
         * identity : null
         * teachingGroup : null
         * visitedCountry : null
         * postType : null
         * deputyPostType : null
         * dimissionReason : null
         * professionTechnicalPost : null
         * partTimeJob : null
         * teacherSource : null
         * mandarinLevelCode : null
         * highestEduDegreeCode : null
         * highestEduDegreeGraduate : null
         * highestCertificateCode : null
         * highestCertificateGraduate : null
         * teacherCertificateTypeCode : null
         * jobCode : null
         * professionTechnicalPostCode : null
         * postTypeCode : null
         * postLevelCode : null
         * officeStatus : null
         * employEndDate : null
         */

        private String id;
        private String createTime;
        private String creator;
        private String updateTime;
        private String modificator;
        private String userId;
        private String schoolId;
        private Object teacherCertificate;
        private Object majorSubject;
        private Object professionalTitle;
        private Object professionalTitleDate;
        private Object majorPhase;
        private Object majorGrade;
        private Object job;
        private Object teacherStaffNo;
        private Object pinyin;
        private Object highestEduDegree;
        private Object highestMajor;
        private Object highestCertificate;
        private Object highestEduSystem;
        private Object highestGraduate;
        private Object highestGraduateTime;
        private Object certificateType;
        private Object certificateNum;
        private Object foreignLanguageType;
        private Object foreignLanguageLevel;
        private Object employedDate;
        private String isPayroll;
        private Object mandarinLevel;
        private Object mandarinLevelTime;
        private Object mandarinCertificateNo;
        private Object teachYears;
        private Object individualResume;
        private Object teachBeginTime;
        private Object subjectBackground;
        private Object entryDate;
        private Object employBeginDate;
        private Object originalEduDegree;
        private Object originalMajor;
        private Object originalEduSystem;
        private Object originalGraduate;
        private Object originalGraduateTime;
        private Object officeTel;
        private Object actualPostLevel;
        private Object wagesJob;
        private Object professionalPostType;
        private String isFullTime;
        private Object keyTeacherLevel;
        private Object keyTeacherTime;
        private Object schoolYears;
        private Object uninterruptedStanding;
        private Object professionalCertificate;
        private Object professionalCertificateTime;
        private String isChurchMeans;
        private String isCampFamily;
        private Object spokenEnglishLevel;
        private Object spokenEnglishTime;
        private Object spokenEnglishCertificateNo;
        private Object computerLevel;
        private Object computerLevelTime;
        private Object computerCertificateNo;
        private Object teacherCertificateType;
        private Object identity;
        private Object teachingGroup;
        private Object visitedCountry;
        private Object postType;
        private Object deputyPostType;
        private Object dimissionReason;
        private Object professionTechnicalPost;
        private Object partTimeJob;
        private Object teacherSource;
        private Object mandarinLevelCode;
        private Object highestEduDegreeCode;
        private Object highestEduDegreeGraduate;
        private Object highestCertificateCode;
        private Object highestCertificateGraduate;
        private Object teacherCertificateTypeCode;
        private Object jobCode;
        private Object professionTechnicalPostCode;
        private Object postTypeCode;
        private Object postLevelCode;
        private Object officeStatus;
        private Object employEndDate;
        private List<DepartmentListBean> departmentList;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getCreator() {
            return creator;
        }

        public void setCreator(String creator) {
            this.creator = creator;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public String getModificator() {
            return modificator;
        }

        public void setModificator(String modificator) {
            this.modificator = modificator;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getSchoolId() {
            return schoolId;
        }

        public void setSchoolId(String schoolId) {
            this.schoolId = schoolId;
        }

        public Object getTeacherCertificate() {
            return teacherCertificate;
        }

        public void setTeacherCertificate(Object teacherCertificate) {
            this.teacherCertificate = teacherCertificate;
        }

        public Object getMajorSubject() {
            return majorSubject;
        }

        public void setMajorSubject(Object majorSubject) {
            this.majorSubject = majorSubject;
        }

        public Object getProfessionalTitle() {
            return professionalTitle;
        }

        public void setProfessionalTitle(Object professionalTitle) {
            this.professionalTitle = professionalTitle;
        }

        public Object getProfessionalTitleDate() {
            return professionalTitleDate;
        }

        public void setProfessionalTitleDate(Object professionalTitleDate) {
            this.professionalTitleDate = professionalTitleDate;
        }

        public Object getMajorPhase() {
            return majorPhase;
        }

        public void setMajorPhase(Object majorPhase) {
            this.majorPhase = majorPhase;
        }

        public Object getMajorGrade() {
            return majorGrade;
        }

        public void setMajorGrade(Object majorGrade) {
            this.majorGrade = majorGrade;
        }

        public Object getJob() {
            return job;
        }

        public void setJob(Object job) {
            this.job = job;
        }

        public Object getTeacherStaffNo() {
            return teacherStaffNo;
        }

        public void setTeacherStaffNo(Object teacherStaffNo) {
            this.teacherStaffNo = teacherStaffNo;
        }

        public Object getPinyin() {
            return pinyin;
        }

        public void setPinyin(Object pinyin) {
            this.pinyin = pinyin;
        }

        public Object getHighestEduDegree() {
            return highestEduDegree;
        }

        public void setHighestEduDegree(Object highestEduDegree) {
            this.highestEduDegree = highestEduDegree;
        }

        public Object getHighestMajor() {
            return highestMajor;
        }

        public void setHighestMajor(Object highestMajor) {
            this.highestMajor = highestMajor;
        }

        public Object getHighestCertificate() {
            return highestCertificate;
        }

        public void setHighestCertificate(Object highestCertificate) {
            this.highestCertificate = highestCertificate;
        }

        public Object getHighestEduSystem() {
            return highestEduSystem;
        }

        public void setHighestEduSystem(Object highestEduSystem) {
            this.highestEduSystem = highestEduSystem;
        }

        public Object getHighestGraduate() {
            return highestGraduate;
        }

        public void setHighestGraduate(Object highestGraduate) {
            this.highestGraduate = highestGraduate;
        }

        public Object getHighestGraduateTime() {
            return highestGraduateTime;
        }

        public void setHighestGraduateTime(Object highestGraduateTime) {
            this.highestGraduateTime = highestGraduateTime;
        }

        public Object getCertificateType() {
            return certificateType;
        }

        public void setCertificateType(Object certificateType) {
            this.certificateType = certificateType;
        }

        public Object getCertificateNum() {
            return certificateNum;
        }

        public void setCertificateNum(Object certificateNum) {
            this.certificateNum = certificateNum;
        }

        public Object getForeignLanguageType() {
            return foreignLanguageType;
        }

        public void setForeignLanguageType(Object foreignLanguageType) {
            this.foreignLanguageType = foreignLanguageType;
        }

        public Object getForeignLanguageLevel() {
            return foreignLanguageLevel;
        }

        public void setForeignLanguageLevel(Object foreignLanguageLevel) {
            this.foreignLanguageLevel = foreignLanguageLevel;
        }

        public Object getEmployedDate() {
            return employedDate;
        }

        public void setEmployedDate(Object employedDate) {
            this.employedDate = employedDate;
        }

        public String getIsPayroll() {
            return isPayroll;
        }

        public void setIsPayroll(String isPayroll) {
            this.isPayroll = isPayroll;
        }

        public Object getMandarinLevel() {
            return mandarinLevel;
        }

        public void setMandarinLevel(Object mandarinLevel) {
            this.mandarinLevel = mandarinLevel;
        }

        public Object getMandarinLevelTime() {
            return mandarinLevelTime;
        }

        public void setMandarinLevelTime(Object mandarinLevelTime) {
            this.mandarinLevelTime = mandarinLevelTime;
        }

        public Object getMandarinCertificateNo() {
            return mandarinCertificateNo;
        }

        public void setMandarinCertificateNo(Object mandarinCertificateNo) {
            this.mandarinCertificateNo = mandarinCertificateNo;
        }

        public Object getTeachYears() {
            return teachYears;
        }

        public void setTeachYears(Object teachYears) {
            this.teachYears = teachYears;
        }

        public Object getIndividualResume() {
            return individualResume;
        }

        public void setIndividualResume(Object individualResume) {
            this.individualResume = individualResume;
        }

        public Object getTeachBeginTime() {
            return teachBeginTime;
        }

        public void setTeachBeginTime(Object teachBeginTime) {
            this.teachBeginTime = teachBeginTime;
        }

        public Object getSubjectBackground() {
            return subjectBackground;
        }

        public void setSubjectBackground(Object subjectBackground) {
            this.subjectBackground = subjectBackground;
        }

        public Object getEntryDate() {
            return entryDate;
        }

        public void setEntryDate(Object entryDate) {
            this.entryDate = entryDate;
        }

        public Object getEmployBeginDate() {
            return employBeginDate;
        }

        public void setEmployBeginDate(Object employBeginDate) {
            this.employBeginDate = employBeginDate;
        }

        public Object getOriginalEduDegree() {
            return originalEduDegree;
        }

        public void setOriginalEduDegree(Object originalEduDegree) {
            this.originalEduDegree = originalEduDegree;
        }

        public Object getOriginalMajor() {
            return originalMajor;
        }

        public void setOriginalMajor(Object originalMajor) {
            this.originalMajor = originalMajor;
        }

        public Object getOriginalEduSystem() {
            return originalEduSystem;
        }

        public void setOriginalEduSystem(Object originalEduSystem) {
            this.originalEduSystem = originalEduSystem;
        }

        public Object getOriginalGraduate() {
            return originalGraduate;
        }

        public void setOriginalGraduate(Object originalGraduate) {
            this.originalGraduate = originalGraduate;
        }

        public Object getOriginalGraduateTime() {
            return originalGraduateTime;
        }

        public void setOriginalGraduateTime(Object originalGraduateTime) {
            this.originalGraduateTime = originalGraduateTime;
        }

        public Object getOfficeTel() {
            return officeTel;
        }

        public void setOfficeTel(Object officeTel) {
            this.officeTel = officeTel;
        }

        public Object getActualPostLevel() {
            return actualPostLevel;
        }

        public void setActualPostLevel(Object actualPostLevel) {
            this.actualPostLevel = actualPostLevel;
        }

        public Object getWagesJob() {
            return wagesJob;
        }

        public void setWagesJob(Object wagesJob) {
            this.wagesJob = wagesJob;
        }

        public Object getProfessionalPostType() {
            return professionalPostType;
        }

        public void setProfessionalPostType(Object professionalPostType) {
            this.professionalPostType = professionalPostType;
        }

        public String getIsFullTime() {
            return isFullTime;
        }

        public void setIsFullTime(String isFullTime) {
            this.isFullTime = isFullTime;
        }

        public Object getKeyTeacherLevel() {
            return keyTeacherLevel;
        }

        public void setKeyTeacherLevel(Object keyTeacherLevel) {
            this.keyTeacherLevel = keyTeacherLevel;
        }

        public Object getKeyTeacherTime() {
            return keyTeacherTime;
        }

        public void setKeyTeacherTime(Object keyTeacherTime) {
            this.keyTeacherTime = keyTeacherTime;
        }

        public Object getSchoolYears() {
            return schoolYears;
        }

        public void setSchoolYears(Object schoolYears) {
            this.schoolYears = schoolYears;
        }

        public Object getUninterruptedStanding() {
            return uninterruptedStanding;
        }

        public void setUninterruptedStanding(Object uninterruptedStanding) {
            this.uninterruptedStanding = uninterruptedStanding;
        }

        public Object getProfessionalCertificate() {
            return professionalCertificate;
        }

        public void setProfessionalCertificate(Object professionalCertificate) {
            this.professionalCertificate = professionalCertificate;
        }

        public Object getProfessionalCertificateTime() {
            return professionalCertificateTime;
        }

        public void setProfessionalCertificateTime(Object professionalCertificateTime) {
            this.professionalCertificateTime = professionalCertificateTime;
        }

        public String getIsChurchMeans() {
            return isChurchMeans;
        }

        public void setIsChurchMeans(String isChurchMeans) {
            this.isChurchMeans = isChurchMeans;
        }

        public String getIsCampFamily() {
            return isCampFamily;
        }

        public void setIsCampFamily(String isCampFamily) {
            this.isCampFamily = isCampFamily;
        }

        public Object getSpokenEnglishLevel() {
            return spokenEnglishLevel;
        }

        public void setSpokenEnglishLevel(Object spokenEnglishLevel) {
            this.spokenEnglishLevel = spokenEnglishLevel;
        }

        public Object getSpokenEnglishTime() {
            return spokenEnglishTime;
        }

        public void setSpokenEnglishTime(Object spokenEnglishTime) {
            this.spokenEnglishTime = spokenEnglishTime;
        }

        public Object getSpokenEnglishCertificateNo() {
            return spokenEnglishCertificateNo;
        }

        public void setSpokenEnglishCertificateNo(Object spokenEnglishCertificateNo) {
            this.spokenEnglishCertificateNo = spokenEnglishCertificateNo;
        }

        public Object getComputerLevel() {
            return computerLevel;
        }

        public void setComputerLevel(Object computerLevel) {
            this.computerLevel = computerLevel;
        }

        public Object getComputerLevelTime() {
            return computerLevelTime;
        }

        public void setComputerLevelTime(Object computerLevelTime) {
            this.computerLevelTime = computerLevelTime;
        }

        public Object getComputerCertificateNo() {
            return computerCertificateNo;
        }

        public void setComputerCertificateNo(Object computerCertificateNo) {
            this.computerCertificateNo = computerCertificateNo;
        }

        public Object getTeacherCertificateType() {
            return teacherCertificateType;
        }

        public void setTeacherCertificateType(Object teacherCertificateType) {
            this.teacherCertificateType = teacherCertificateType;
        }

        public Object getIdentity() {
            return identity;
        }

        public void setIdentity(Object identity) {
            this.identity = identity;
        }

        public Object getTeachingGroup() {
            return teachingGroup;
        }

        public void setTeachingGroup(Object teachingGroup) {
            this.teachingGroup = teachingGroup;
        }

        public Object getVisitedCountry() {
            return visitedCountry;
        }

        public void setVisitedCountry(Object visitedCountry) {
            this.visitedCountry = visitedCountry;
        }

        public Object getPostType() {
            return postType;
        }

        public void setPostType(Object postType) {
            this.postType = postType;
        }

        public Object getDeputyPostType() {
            return deputyPostType;
        }

        public void setDeputyPostType(Object deputyPostType) {
            this.deputyPostType = deputyPostType;
        }

        public Object getDimissionReason() {
            return dimissionReason;
        }

        public void setDimissionReason(Object dimissionReason) {
            this.dimissionReason = dimissionReason;
        }

        public Object getProfessionTechnicalPost() {
            return professionTechnicalPost;
        }

        public void setProfessionTechnicalPost(Object professionTechnicalPost) {
            this.professionTechnicalPost = professionTechnicalPost;
        }

        public Object getPartTimeJob() {
            return partTimeJob;
        }

        public void setPartTimeJob(Object partTimeJob) {
            this.partTimeJob = partTimeJob;
        }

        public Object getTeacherSource() {
            return teacherSource;
        }

        public void setTeacherSource(Object teacherSource) {
            this.teacherSource = teacherSource;
        }

        public Object getMandarinLevelCode() {
            return mandarinLevelCode;
        }

        public void setMandarinLevelCode(Object mandarinLevelCode) {
            this.mandarinLevelCode = mandarinLevelCode;
        }

        public Object getHighestEduDegreeCode() {
            return highestEduDegreeCode;
        }

        public void setHighestEduDegreeCode(Object highestEduDegreeCode) {
            this.highestEduDegreeCode = highestEduDegreeCode;
        }

        public Object getHighestEduDegreeGraduate() {
            return highestEduDegreeGraduate;
        }

        public void setHighestEduDegreeGraduate(Object highestEduDegreeGraduate) {
            this.highestEduDegreeGraduate = highestEduDegreeGraduate;
        }

        public Object getHighestCertificateCode() {
            return highestCertificateCode;
        }

        public void setHighestCertificateCode(Object highestCertificateCode) {
            this.highestCertificateCode = highestCertificateCode;
        }

        public Object getHighestCertificateGraduate() {
            return highestCertificateGraduate;
        }

        public void setHighestCertificateGraduate(Object highestCertificateGraduate) {
            this.highestCertificateGraduate = highestCertificateGraduate;
        }

        public Object getTeacherCertificateTypeCode() {
            return teacherCertificateTypeCode;
        }

        public void setTeacherCertificateTypeCode(Object teacherCertificateTypeCode) {
            this.teacherCertificateTypeCode = teacherCertificateTypeCode;
        }

        public Object getJobCode() {
            return jobCode;
        }

        public void setJobCode(Object jobCode) {
            this.jobCode = jobCode;
        }

        public Object getProfessionTechnicalPostCode() {
            return professionTechnicalPostCode;
        }

        public void setProfessionTechnicalPostCode(Object professionTechnicalPostCode) {
            this.professionTechnicalPostCode = professionTechnicalPostCode;
        }

        public Object getPostTypeCode() {
            return postTypeCode;
        }

        public void setPostTypeCode(Object postTypeCode) {
            this.postTypeCode = postTypeCode;
        }

        public Object getPostLevelCode() {
            return postLevelCode;
        }

        public void setPostLevelCode(Object postLevelCode) {
            this.postLevelCode = postLevelCode;
        }

        public Object getOfficeStatus() {
            return officeStatus;
        }

        public void setOfficeStatus(Object officeStatus) {
            this.officeStatus = officeStatus;
        }

        public Object getEmployEndDate() {
            return employEndDate;
        }

        public void setEmployEndDate(Object employEndDate) {
            this.employEndDate = employEndDate;
        }

        public List<DepartmentListBean> getDepartmentList() {
            return departmentList;
        }

        public void setDepartmentList(List<DepartmentListBean> departmentList) {
            this.departmentList = departmentList;
        }

        public static class DepartmentListBean {
            /**
             * id : 1000000000003411190
             * departmentName : 摩信部门2
             * userOrdernoInDepartment : 7
             * isPartTime : 0
             */

            private String id;
            private String departmentName;
            private int userOrdernoInDepartment;
            private int isPartTime;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getDepartmentName() {
                return departmentName;
            }

            public void setDepartmentName(String departmentName) {
                this.departmentName = departmentName;
            }

            public int getUserOrdernoInDepartment() {
                return userOrdernoInDepartment;
            }

            public void setUserOrdernoInDepartment(int userOrdernoInDepartment) {
                this.userOrdernoInDepartment = userOrdernoInDepartment;
            }

            public int getIsPartTime() {
                return isPartTime;
            }

            public void setIsPartTime(int isPartTime) {
                this.isPartTime = isPartTime;
            }
        }
    }

    public static class AccountRoleListBean {
        /**
         * id : teacher
         * createTime : null
         * creator : null
         * updateTime : null
         * modificator : null
         * roleName : 普通教职工
         * roleCode : null
         * remark : null
         * appId : null
         * roleType : null
         * autoGrant : null
         * systemRole : null
         * usertype : null
         * areaScope : null
         * orderno : null
         * positionLevel : null
         * schoolId : null
         * endTime : null
         * dataScope : null
         * schoolName : null
         * defaultFlag : false
         * accountId : null
         */

        private String id;
        private Object createTime;
        private Object creator;
        private Object updateTime;
        private Object modificator;
        private String roleName;
        private Object roleCode;
        private Object remark;
        private Object appId;
        private Object roleType;
        private Object autoGrant;
        private Object systemRole;
        private Object usertype;
        private Object areaScope;
        private Object orderno;
        private Object positionLevel;
        private Object schoolId;
        private Object endTime;
        private Object dataScope;
        private Object schoolName;
        private boolean defaultFlag;
        private Object accountId;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Object getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Object createTime) {
            this.createTime = createTime;
        }

        public Object getCreator() {
            return creator;
        }

        public void setCreator(Object creator) {
            this.creator = creator;
        }

        public Object getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Object updateTime) {
            this.updateTime = updateTime;
        }

        public Object getModificator() {
            return modificator;
        }

        public void setModificator(Object modificator) {
            this.modificator = modificator;
        }

        public String getRoleName() {
            return roleName;
        }

        public void setRoleName(String roleName) {
            this.roleName = roleName;
        }

        public Object getRoleCode() {
            return roleCode;
        }

        public void setRoleCode(Object roleCode) {
            this.roleCode = roleCode;
        }

        public Object getRemark() {
            return remark;
        }

        public void setRemark(Object remark) {
            this.remark = remark;
        }

        public Object getAppId() {
            return appId;
        }

        public void setAppId(Object appId) {
            this.appId = appId;
        }

        public Object getRoleType() {
            return roleType;
        }

        public void setRoleType(Object roleType) {
            this.roleType = roleType;
        }

        public Object getAutoGrant() {
            return autoGrant;
        }

        public void setAutoGrant(Object autoGrant) {
            this.autoGrant = autoGrant;
        }

        public Object getSystemRole() {
            return systemRole;
        }

        public void setSystemRole(Object systemRole) {
            this.systemRole = systemRole;
        }

        public Object getUsertype() {
            return usertype;
        }

        public void setUsertype(Object usertype) {
            this.usertype = usertype;
        }

        public Object getAreaScope() {
            return areaScope;
        }

        public void setAreaScope(Object areaScope) {
            this.areaScope = areaScope;
        }

        public Object getOrderno() {
            return orderno;
        }

        public void setOrderno(Object orderno) {
            this.orderno = orderno;
        }

        public Object getPositionLevel() {
            return positionLevel;
        }

        public void setPositionLevel(Object positionLevel) {
            this.positionLevel = positionLevel;
        }

        public Object getSchoolId() {
            return schoolId;
        }

        public void setSchoolId(Object schoolId) {
            this.schoolId = schoolId;
        }

        public Object getEndTime() {
            return endTime;
        }

        public void setEndTime(Object endTime) {
            this.endTime = endTime;
        }

        public Object getDataScope() {
            return dataScope;
        }

        public void setDataScope(Object dataScope) {
            this.dataScope = dataScope;
        }

        public Object getSchoolName() {
            return schoolName;
        }

        public void setSchoolName(Object schoolName) {
            this.schoolName = schoolName;
        }

        public boolean isDefaultFlag() {
            return defaultFlag;
        }

        public void setDefaultFlag(boolean defaultFlag) {
            this.defaultFlag = defaultFlag;
        }

        public Object getAccountId() {
            return accountId;
        }

        public void setAccountId(Object accountId) {
            this.accountId = accountId;
        }
    }
}

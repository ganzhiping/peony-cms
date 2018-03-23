package com.peony.peonydata.util.log;

import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.peony.core.base.pojo.BasePojo;
import com.peony.core.common.utils.JsonDateSerializer;

/**
 * 系统日志pojo
 *
 * @date 2013-11-15 下午03:25:02
 * @author zhaoshutao
 * @version 1
 */
public class SysLog extends BasePojo {

    /**
     * 序列化ID
     */
    private static final long serialVersionUID = -8940030965648892954L;

    /**
     * id
     */
    private String            id;
    /**
     * 描述
     */
    private String            description;
    /**
     * 操作模块
     */
    private String            operateMode;
    /**
     * 操作类型 1 增加 2 删除 3 更新 4 查询
     */
    private String            operateType;
    /**
     * 操作时间
     */
    private Date              operateDate;
    /**
     * 操作用户id
     */
    private String            uid;
    /**
     * 操作用户名
     */
    private String            userName;
    /**
     * 操作用户姓名
     */
    private String            fullName;

    /**
     * 默认构造器
     */
    public SysLog() {
    }

    /**
     * 构造器
     *
     * @param id
     * @param description
     *            描述
     * @param operateMode
     *            操作模块
     * @param operateType
     *            操作类型 1 增加 2 删除 3 更新 4 查询
     * @param operateDate
     *            操作时间
     * @param uid
     *            操作用户id
     * @param userName
     *            操作用户名
     * @param fullName
     *            操作用户姓名
     */
    public SysLog(String id, String description, String operateMode, String operateType, Date operateDate, String uid, String userName, String fullName) {
        this.id = id;
        this.description = description;
        this.operateMode = operateMode;
        this.operateType = operateType;
        this.operateDate = operateDate;
        this.uid = uid;
        this.userName = userName;
        this.fullName = fullName;
    }

    /**
     * 构造器
     *
     * @param description
     *            描述
     * @param operateMode
     *            操作模块
     * @param operateType
     *            操作类型 1 增加 2 删除 3 更新 4 查询
     * @param operateDate
     *            操作时间
     * @param uid
     *            操作用户id
     * @param userName
     *            操作用户名
     * @param fullName
     *            操作用户姓名
     */
    public SysLog(String description, String operateMode, String operateType, Date operateDate, String uid, String userName, String fullName) {
        this.description = description;
        this.operateMode = operateMode;
        this.operateType = operateType;
        this.operateDate = operateDate;
        this.uid = uid;
        this.userName = userName;
        this.fullName = fullName;
    }

    /**
     * 获取id
     *
     * @return String
     */
    public String getId() {
        return this.id;
    }

    /**
     * 设置id
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取描述
     *
     * @return String
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * 设置描述
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取操作模块
     *
     * @return String
     */
    public String getOperateMode() {
        return this.operateMode;
    }

    /**
     * 设置操作模块
     *
     * @param operateMode
     */
    public void setOperateMode(String operateMode) {
        this.operateMode = operateMode;
    }

    /**
     * 获取操作类型
     *
     * @return String
     */
    public String getOperateType() {
        return this.operateType;
    }

    /**
     * 设置操作类型
     *
     * @param operateType
     */
    public void setOperateType(String operateType) {
        this.operateType = operateType;
    }

    /**
     * 获取操作用户id
     *
     * @return String
     */
    public String getUid() {
        return this.uid;
    }

    /**
     * 设置操作用户id
     *
     * @param uid
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * 获取用户名
     *
     * @return String
     */
    public String getUserName() {
        return this.userName;
    }

    /**
     * 设置用户名
     *
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取操作用户姓名
     *
     * @return String
     */
    public String getFullName() {
        return this.fullName;
    }

    /**
     * 设置操作用户姓名
     *
     * @param fullName
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * 获取操作时间
     *
     * @return Date
     */
    @JsonSerialize(using = JsonDateSerializer.class)
    public Date getOperateDate() {
        return this.operateDate;
    }

    /**
     * 设置操作时间
     *
     * @param operateDate
     */
    public void setOperateDate(Date operateDate) {
        this.operateDate = operateDate;
    }

}

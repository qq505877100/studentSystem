package com.biz.stu.common;

/**这是一个标志类，用于给各种操作成功与否做个标记，比如选课成功就把关于选课的标记设置为true,
 * 否则为false
 * @author fuxianhui
 * @Description:
 * @Date: create in 23:17 2017/8/7
 */
public class Flag {
    //选课成功设置为1,失败设置为0
    private String selectedCourse;

    //根据班级名称查询是否存在该班级的标志1,存在，0不存在
    private String classExist;

    //退课成功设置为1，失败设置为0
    private String unBindingCourse;

    public String getUnBindingCourse() {
        return unBindingCourse;
    }

    public void setUnBindingCourse(String unBindingCourse) {
        this.unBindingCourse = unBindingCourse;
    }

    public String getClassExist() {
        return classExist;
    }

    public void setClassExist(String classExist) {
        this.classExist = classExist;
    }

    public String getSelectedCourse() {
        return selectedCourse;
    }

    public void setSelectedCourse(String selectedCourse) {
        this.selectedCourse = selectedCourse;
    }
}

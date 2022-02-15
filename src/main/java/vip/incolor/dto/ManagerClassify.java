package vip.incolor.dto;

/**
 * @author LinPython
 * @email ly546654542@gmail.com
 * @description
 * @date 2018/5/9
 * @time 22:53
 */
public class ManagerClassify {
    /**
     * 分类ID
     */
    private Integer classifyId;
    /**
     * 产品分类名称
     */
    private String classifyName;
    /**
     * 是否为一级类目，是就是1，0为二级类目
     */
    private Boolean isParent;
    /**
     * 父类目的 id,如果是一级类目，为 -1 ，如果是二级类目，为 父类目的 id
     */
    private Integer parentId;

    public ManagerClassify(){
    }

    public ManagerClassify(Integer classifyId, String classifyName, Boolean isParent, Integer parentId){
        this.classifyId = classifyId;
        this.classifyName = classifyName;
        this.isParent = isParent;
        this.parentId = parentId;
    }



    public Integer getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(Integer classifyId) {
        this.classifyId = classifyId;
    }

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName;
    }

    public Boolean getParent() {
        return isParent;
    }

    public void setParent(Boolean parent) {
        isParent = parent;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }


}

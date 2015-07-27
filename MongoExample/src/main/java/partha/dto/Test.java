package partha.dto;

/**
 *
 * @author Partha
 */
public class Test {
    
    private Object _id;//make sure you define this Object _id, this for the mongo object id
    private String name;
    private String address;
    private String info;
    private String status;
    private String createdate;
    private String updatedate;

    public Object getId() {
        return _id;
    }

    public void setId(Object _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Test{" + "_id=" + _id + ", name=" + name + ", address=" + address + ", info=" + info + ", status=" + status + ", createdate=" + createdate + ", updatedate=" + updatedate + '}';
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    public String getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(String updatedate) {
        this.updatedate = updatedate;
    }

}

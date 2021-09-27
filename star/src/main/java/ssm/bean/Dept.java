package cn.tedu.ssm.bean;

import java.io.Serializable;

public class Dept implements Serializable{
	
	private static final long serialVersionUID = 8915715666324670320L;
	private Integer id;
	private String deptName;
	private String deptAddress;
	public Dept(){
		
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deptAddress == null) ? 0 : deptAddress.hashCode());
		result = prime * result + ((deptName == null) ? 0 : deptName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dept other = (Dept) obj;
		if (deptAddress == null) {
			if (other.deptAddress != null)
				return false;
		} else if (!deptAddress.equals(other.deptAddress))
			return false;
		if (deptName == null) {
			if (other.deptName != null)
				return false;
		} else if (!deptName.equals(other.deptName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Dept [id=" + id + ", deptName=" + deptName + ", deptAddress=" + deptAddress + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDeptAddress() {
		return deptAddress;
	}
	public void setDeptAddress(String deptAddress) {
		this.deptAddress = deptAddress;
	}
	public Dept(Integer id, String deptName, String deptAddress) {
		super();
		this.id = id;
		this.deptName = deptName;
		this.deptAddress = deptAddress;
	}

}

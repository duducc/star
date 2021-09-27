package star.bean;

import java.io.Serializable;

public class WkAddress implements Serializable{
		/**
		* 
		*/
	    private static final long serialVersionUID = 1L;
	    
		private long id;
		private String address;
		private String desc;
		private String type;
	    private String category;
	    private String extractcode;
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getDesc() {
			return desc;
		}
		public void setDesc(String desc) {
			this.desc = desc;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public String getExtractcode() {
			return extractcode;
		}
		public void setExtractcode(String extractcode) {
			this.extractcode = extractcode;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((address == null) ? 0 : address.hashCode());
			result = prime * result + ((category == null) ? 0 : category.hashCode());
			result = prime * result + ((desc == null) ? 0 : desc.hashCode());
			result = prime * result + ((extractcode == null) ? 0 : extractcode.hashCode());
			result = prime * result + (int) (id ^ (id >>> 32));
			result = prime * result + ((type == null) ? 0 : type.hashCode());
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
			WkAddress other = (WkAddress) obj;
			if (address == null) {
				if (other.address != null)
					return false;
			} else if (!address.equals(other.address))
				return false;
			if (category == null) {
				if (other.category != null)
					return false;
			} else if (!category.equals(other.category))
				return false;
			if (desc == null) {
				if (other.desc != null)
					return false;
			} else if (!desc.equals(other.desc))
				return false;
			if (extractcode == null) {
				if (other.extractcode != null)
					return false;
			} else if (!extractcode.equals(other.extractcode))
				return false;
			if (id != other.id)
				return false;
			if (type == null) {
				if (other.type != null)
					return false;
			} else if (!type.equals(other.type))
				return false;
			return true;
		}
		@Override
		public String toString() {
			return "WkAddress [id=" + id + ", address=" + address + ", desc=" + desc + ", type=" + type + ", category="
					+ category + ", extractcode=" + extractcode + "]";
		}
		


}

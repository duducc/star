package star.mapper;

import java.util.List;

import star.bean.WkAddress;

public interface WkAddressMapper {
   List<WkAddress> selectAll();
   
   int addWkAddress(WkAddress wkAddress);
}

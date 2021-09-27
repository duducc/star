package star.service;


import java.util.List;

import star.bean.WkAddress;


public interface WkAddressService {
   List<WkAddress> selectAll();
   
   int addWkAddress(WkAddress wkAddress);
}

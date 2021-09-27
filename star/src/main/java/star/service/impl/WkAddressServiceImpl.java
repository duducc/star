package star.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import star.bean.WkAddress;
import star.mapper.WkAddressMapper;
import star.service.WkAddressService;

@Service
public class WkAddressServiceImpl implements WkAddressService {
	@Resource
    private WkAddressMapper  wkAddressMapper;
	
	public List<WkAddress> selectAll() {
		return wkAddressMapper.selectAll();
	}

	public int addWkAddress(WkAddress wkAddress) {
		return wkAddressMapper.addWkAddress(wkAddress);
	}

}

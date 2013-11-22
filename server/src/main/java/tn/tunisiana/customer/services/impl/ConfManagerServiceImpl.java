package tn.tunisiana.customer.services.impl;

import java.util.List;

import tn.tunisiana.customer.services.IConfManagerService;
import tn.tunisiana.customer.util.GlobalConf;

public class ConfManagerServiceImpl  implements
		IConfManagerService {

	

	public List<String> getGouvernorats() {

		return GlobalConf.getGouvernorats();
	}

}

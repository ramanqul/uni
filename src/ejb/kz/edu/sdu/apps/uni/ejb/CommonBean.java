package kz.edu.sdu.apps.uni.ejb;
import javax.ejb.Stateless;

import kz.edu.sdu.apps.uni.client.ICommonBeanLocal;

@Stateless
public class CommonBean implements ICommonBeanLocal{
	@Override
	public String test() {
		return "Test";
	}
}

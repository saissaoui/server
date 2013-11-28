package tn.tunisiana.customer.business;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import tn.tunisiana.customer.model.Correspondance;
import tn.tunisiana.customer.model.Customer;
import tn.tunisiana.customer.model.Offer;
import tn.tunisiana.customer.model.Segment;
import bsh.EvalError;
import bsh.Interpreter;

public class SegmentTester {

	private List<Segment> segments;

	public List<Offer> defineOffers(Customer customer) {

		Interpreter interpreter = new Interpreter();
		List<Offer> offers = new ArrayList<Offer>();

		for (Segment segment : segments) {
			try {

				Method getCritereValue;
				try {
					getCritereValue = customer.getClass().getMethod(
							"get" + segment.getCritere());

					interpreter.set("critereValue", Integer
							.parseInt(getCritereValue.invoke(customer)
									.toString()));

					String expression = "( ";

					for (Correspondance corresp : segment.getCorrespondances()) {
						for (String condition : corresp.getConditions().split(
								"/")) {
							expression += "(critereValue " + condition
									+ ") && ";

						}
						if (expression.endsWith("&& "))
							expression = expression.substring(0,
									expression.length() - 3);
						expression += ")";

						interpreter.eval("isOk = " + expression);

						boolean isOk = (Boolean) interpreter.get("isOk");

						if (isOk)
							offers.add(corresp.getOffre());

						expression = "( ";
					}
				} catch (EvalError e) {

					e.printStackTrace();
				}
			} catch (NoSuchMethodException e) {

				e.printStackTrace();
			} catch (SecurityException e) {

				e.printStackTrace();
			} catch (IllegalAccessException e) {

				e.printStackTrace();
			} catch (IllegalArgumentException e) {

				e.printStackTrace();
			} catch (InvocationTargetException e) {

				e.printStackTrace();
			}
		}

		return offers;
	}

	public List<Segment> getSegments() {
		return segments;
	}

	public void setSegments(List<Segment> segments) {
		this.segments = segments;
	}

}

package tn.tunisiana.customer.business;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import tn.tunisiana.customer.model.Condition;
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

				try {

					for (Correspondance corresp : segment.getCorrespondances()) {
						String expression = "( ";
						for (Condition condition : corresp.getConditions()) {

							Method getCritereValue;
							expression += "(critereValue "
									+ condition.getValeurs() + ") && ";
							getCritereValue = customer.getClass().getMethod(
									"get" + condition.getCritere());

							interpreter.set(
									"critereValue",
									Integer.parseInt(getCritereValue.invoke(
											customer).toString()));

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

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
		int critereNumber;
		for (Segment segment : segments) {

			try {
				critereNumber = 0;
				for (Correspondance corresp : segment.getCorrespondances()) {
					String expression = "( ";
					for (Condition condition : corresp.getConditions()) {

						Method getCritereValue;
						expression += "(critereValue" + critereNumber
								+ condition.getValeurs() + ") && ";
						getCritereValue = customer.getClass().getMethod(
								"get" + condition.getCritere());
						if (getCritereValue.invoke(customer) instanceof Integer
								|| getCritereValue.invoke(customer) instanceof Long)
							interpreter.set(
									"critereValue" + critereNumber,
									Integer.parseInt(getCritereValue.invoke(
											customer).toString()));
						else if (getCritereValue.invoke(customer) instanceof String)
							interpreter
									.set("critereValue" + critereNumber,
											getCritereValue.invoke(customer)
													.toString());
						else if (getCritereValue.invoke(customer) instanceof Boolean)
							interpreter.set("critereValue" + critereNumber,
									Boolean.parseBoolean((getCritereValue
											.invoke(customer).toString())));
						critereNumber++;
					}
					if (expression.endsWith("&& "))
						expression = expression.substring(0,
								expression.length() - 3);
					expression += ")";

					interpreter.eval("isOk = " + expression);

					boolean isOk = (Boolean) interpreter.get("isOk");

					if (isOk)
						for (Offer offer : corresp.getOffres())
							if (!offers.contains(offer))
								offers.add(offer);

					expression = "( ";
				}

			} catch (EvalError e) {

				e.printStackTrace();
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

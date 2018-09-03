package numericSystem;

public class RationalNumber<T extends Number> implements IRationalNumber<RationalNumber<Number>> {

	
	private T numerador;
	private T denominador;
	
	
	 public RationalNumber(T numerador, T denominador) {
		
		
		this.numerador= numerador;
		this.denominador= denominador;
		
		
	}
	
	
	
	@Override
	public void addRational(RationalNumber<Number> rationalToBeAdded) {
		
		
		if(denominador== rationalToBeAdded.getDenominator()) {
			this.numerador= add(numerador, (T)rationalToBeAdded.getNumerator());
			
		}else {
			
			
			T n1= multiply(numerador,(T) rationalToBeAdded.getDenominator());
			T n2= multiply(denominador,(T) rationalToBeAdded.getNumerator());
			this.numerador= add(n1,n2);
			this.denominador=multiply(denominador,(T) rationalToBeAdded.getDenominator()); 
		}
		
		simplifyRational();
			
		 
		
	}

	private T add(T n1, T n2) {
		T number=null;
		 if (n1 instanceof Long|| n2 instanceof Long) {
			number =(T)Long.valueOf(n1.longValue()+n2.longValue());
			
		}else if (n1 instanceof Short) {
			 if(n2 instanceof Integer) {
			number = (T)Integer.valueOf(n1.intValue()+n2.intValue());
			 }
		else if (n2 instanceof Short) {
			number = (T)Short.valueOf((short) (n1.shortValue()+n2.shortValue()));
			
		}}
		else if(n1 instanceof Integer) {
			if(n2 instanceof Short) {
				number = (T)Integer.valueOf(n1.intValue()+n2.intValue());
			}else if(n2 instanceof Integer) {
				number = (T)Integer.valueOf(n1.intValue()+n2.intValue());	
			}
		}
		return number;
	}



	@Override
	public void substractRational(RationalNumber<Number> rationalToBeSubstracted) {
		if(denominador== rationalToBeSubstracted.getDenominator()) {
			this.numerador= substract(numerador, (T)rationalToBeSubstracted.getNumerator());
			
		}else {
			
			
			T n1= multiply(numerador,(T) rationalToBeSubstracted.getDenominator());
			T n2= multiply(denominador,(T) rationalToBeSubstracted.getNumerator());
			this.numerador= substract(n1,n2);
			this.denominador=multiply(denominador,(T) rationalToBeSubstracted.getDenominator()); 
		}
		
		simplifyRational();
		
	}

	private T substract(T n1, T n2) {
		T number=null;
		 if (n1 instanceof Long|| n2 instanceof Long) {
			number =(T)Long.valueOf(n1.longValue()-n2.longValue());
			
		}else if (n1 instanceof Short) {
			 if(n2 instanceof Integer) {
			number = (T)Integer.valueOf(n1.intValue()-n2.intValue());
			 }
		else if (n2 instanceof Short) {
			number = (T)Short.valueOf((short) (n1.shortValue()-n2.shortValue()));
			
		}}
		else if(n1 instanceof Integer) {
			if(n2 instanceof Short) {
				number = (T)Integer.valueOf(n1.intValue()-n2.intValue());
			}else if(n2 instanceof Integer) {
				number = (T)Integer.valueOf(n1.intValue()-n2.intValue());	
			}
		}
		return number;
	}



	@Override
	public void multiplyRational(RationalNumber<Number> rationalFactor) {
		
		this.numerador= multiply(numerador, (T)rationalFactor.getNumerator());
		this.denominador= multiply(denominador, (T)rationalFactor.getDenominator());
		
		simplifyRational();
	}

	private T multiply(T n1, T n2) {
		T number=null;
		 if (n1 instanceof Long|| n2 instanceof Long) {
			number =(T)Long.valueOf(n1.longValue()*n2.longValue());
			
		}else if (n1 instanceof Short) {
			 if(n2 instanceof Integer) {
			number = (T)Integer.valueOf(n1.intValue()*n2.intValue());
			 }
		else if (n2 instanceof Short) {
			number = (T)Short.valueOf((short) (n1.shortValue()*n2.shortValue()));
			
		}}
		else if(n1 instanceof Integer) {
			if(n2 instanceof Short) {
				number = (T)Integer.valueOf(n1.intValue()*n2.intValue());
			}else if(n2 instanceof Integer) {
				number = (T)Integer.valueOf(n1.intValue()*n2.intValue());	
			}
		}
		
		 
		 
		 
		 return number;
		
		
	}



	@Override
	public void divideRational(RationalNumber<Number> rationalQuocient) {
		this.numerador= multiply(numerador, (T)rationalQuocient.getDenominator());
		this.denominador= multiply(denominador,(T) rationalQuocient.getNumerator());
		simplifyRational();
		
	}

	@Override
	public void simplifyRational() {
		
		T mx= maxCoDiv();
	
		if (this.numerador instanceof Long|| this.denominador instanceof Long) {
			this.numerador =(T)Long.valueOf(this.numerador.longValue()/Math.abs(mx.longValue()));
			this.denominador=(T)Long.valueOf(this.denominador.longValue()/Math.abs(mx.longValue()));
			
		}else if (this.numerador instanceof Short) {
			 if(this.denominador instanceof Integer) {
				 this.numerador =(T)Short.valueOf((short)(this.numerador.shortValue()/Math.abs(mx.shortValue())));
					this.denominador=(T)Integer.valueOf(this.denominador.intValue()/Math.abs(mx.intValue()));
			 }
		else if (this.denominador instanceof Short) {
			 this.numerador =(T)Short.valueOf((short)(this.numerador.shortValue()/Math.abs(mx.shortValue())));
			 this.denominador =(T)Short.valueOf((short)(this.denominador.shortValue()/Math.abs(mx.shortValue())));
			
		}}
		else if(this.numerador instanceof Integer) {
			if(this.denominador instanceof Short) {
				this.denominador =(T)Short.valueOf((short)(this.denominador.shortValue()/Math.abs(mx.shortValue())));
				this.numerador=(T)Integer.valueOf(this.numerador.intValue()/Math.abs(mx.intValue()));
			}else if(this.denominador instanceof Integer) {
				this.numerador=(T)Integer.valueOf(this.numerador.intValue()/Math.abs(mx.intValue()));
				this.denominador=(T)Integer.valueOf(this.denominador.intValue()/Math.abs(mx.intValue()));
			}}	
	}

	
	public T maxCoDiv() {
		
		T n1= this.numerador;
		T n2= this.denominador;
		T number2=null;
		
		 if (n1 instanceof Long|| n2 instanceof Long) {
				if(n2.longValue()==0) {
					return n1;
				}else {
					while(n2.longValue()!=0) {
						number2= (T)Long.valueOf(n1.longValue()%n2.longValue());
						n1=n2;
						n2=number2;
					}
				
				}	
				
			}else if (n1 instanceof Short) {
				 if(n2 instanceof Integer) {
					 if(n2.intValue()==0) {
							return n1;
						}else {
							while(n2.intValue()!=0) {
								number2= (T)Integer.valueOf(n1.intValue()%n2.intValue());
								n1=n2;
								n2=number2;
							}}}else if (n2 instanceof Short) {
				
				if(n2.shortValue()==0) {
					return n1;
				}else {
					while(n2.shortValue()!=0) {
						number2= (T)Short.valueOf((short)(n1.shortValue()%n2.shortValue()));
						n1=n2;
						n2=number2;
					}}}}else if(n1 instanceof Integer) {
				if(n2 instanceof Short) {
					if(n2.intValue()==0) {
						return n1;
					}else {
						while(n2.intValue()!=0) {
							number2= (T)Integer.valueOf(n1.intValue()%n2.intValue());
							n1=n2;
							n2=number2;
						}}}else if(n2 instanceof Integer) {
					if(n2.intValue()==0) {
						return n1;
					}else {
						while(n2.intValue()!=0) {
							number2= (T)Integer.valueOf(n1.intValue()%n2.intValue());
							n1=n2;
							n2=number2;
						}}}}	
		
		return n1;
		
	}
	@Override
	public void rationalInverse() {
		T number= this.numerador;
		this.numerador= this.denominador;
		this.denominador= number;
		simplifyRational();
		
		
		
		
		

		
		
	}
	
	
	

	@Override
	public void squaredRational() {
		this.numerador= multiply(numerador, numerador);
		this.denominador= multiply(denominador, denominador);
		simplifyRational();
	}

	@Override
	public Number getNumerator() {
		// TODO Auto-generated method stub
		return numerador;
	}

	@Override
	public Number getDenominator() {
		// TODO Auto-generated method stub
		return denominador;
	}
	
	
	
	

}

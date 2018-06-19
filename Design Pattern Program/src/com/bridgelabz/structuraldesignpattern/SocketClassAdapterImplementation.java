package com.bridgelabz.structuraldesignpattern;

public class SocketClassAdapterImplementation extends Socket implements SocketAdapter {

	@Override
	public Volt get3Volt() {
		Volt v=getVolt();
		return convertVOlt(v, 40);
	}

	@Override
	public Volt get12Volt() {
		Volt v=getVolt();
		return convertVOlt(v, 10);
	}

	@Override
	public Volt get120Volt() {
		return getVolt();
	}
	private Volt convertVOlt(Volt v,int i) {
		double vRes=v.getVolt()/i;
		return new Volt(vRes);
	}
}

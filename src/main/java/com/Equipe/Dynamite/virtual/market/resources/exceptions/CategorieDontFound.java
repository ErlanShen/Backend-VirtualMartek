package com.Equipe.Dynamite.virtual.market.resources.exceptions;

public class CategorieDontFound extends Exception{
	
private static final long serialVersionUID = -7717691994704695707L;
	
	public static final String DESCRIPTION="Product don't found";
	
	public CategorieDontFound() {
		super(DESCRIPTION);
	}
	
	public CategorieDontFound(String message ) {
		super(DESCRIPTION + " " +message);
	}

}

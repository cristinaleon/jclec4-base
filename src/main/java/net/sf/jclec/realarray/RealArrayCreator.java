package net.sf.jclec.realarray;

import net.sf.jclec.ISpecies;

import net.sf.jclec.base.AbstractCreator;

import net.sf.jclec.util.range.IRange;

/**
 * Creation of RealArrayIndividual (and subclasses).
 *  
 * @author Sebastian Ventura
 */

public class RealArrayCreator extends AbstractCreator 
{
	/////////////////////////////////////////////////////////////////
	// --------------------------------------- Serialization constant
	/////////////////////////////////////////////////////////////////
	
	/** Generated by Eclipse */
	
	private static final long serialVersionUID = -2638928425169895614L;

	/////////////////////////////////////////////////////////////////
	// ------------------------------------------- Internal variables
	/////////////////////////////////////////////////////////////////
	
	/** Associated species */
	
	protected transient RealArraySpecies species;
	
	/** Genotype schema */
	
	protected transient IRange [] schema;

	/////////////////////////////////////////////////////////////////
	// ------------------------------------------------- Constructors
	/////////////////////////////////////////////////////////////////
	
	public RealArrayCreator() 
	{
		super();
	}

	/////////////////////////////////////////////////////////////////
	// ----------------------------------------------- Public methods
	/////////////////////////////////////////////////////////////////
	
	// java.lang.Object methods
	
	/**
	 * {@inheritDoc}
	 */
	
	@Override
	public boolean equals(Object other)
	{
		if (other instanceof RealArrayCreator){
			return true;
		}
		else {
			return false;
		}
	}

	/////////////////////////////////////////////////////////////////
	// -------------------------------------------- Protected methods
	/////////////////////////////////////////////////////////////////
	
	// AbstractCreator methods
	
	@Override
	protected void prepareCreation() 
	{
		// Get context species
		ISpecies spc = context.getSpecies();
		if (spc instanceof RealArraySpecies) {
			this.species = (RealArraySpecies) spc;
		}
		else {
			throw new IllegalArgumentException("RealArraySpecies expected");
		}
		// Get individuals schema
		schema = species.getGenotypeSchema();
	}

	@Override
	protected void createNext() 
	{
		createdBuffer.add(species.createIndividual(createGenotype()));
	}
	
	/////////////////////////////////////////////////////////////////
	// ---------------------------------------------- Private methods
	/////////////////////////////////////////////////////////////////
	
	/**
	 * Create a double [] genotype, filling it randomly
	 */
	
	private final double [] createGenotype()
	{
		int gl = schema.length;
		double [] result = new double[gl];
		for(int i=0; i<gl; i++) {
			result [i] = schema[i].getRandom(randgen);
		}		
		return result;
	}	
}

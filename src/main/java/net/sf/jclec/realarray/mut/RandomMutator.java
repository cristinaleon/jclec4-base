package net.sf.jclec.realarray.mut;

import net.sf.jclec.realarray.UniformMutator;

import org.apache.commons.lang.builder.EqualsBuilder;

/** 
 * This mutator applies on each selected individual a random mutation, in other 
 * words, the locus value changes randomly. This value is inside of the locus 
 * interval.
 *
 * @author Alberto Lamarca
 * @author Sebastian Ventura 
 */

public class RandomMutator extends UniformMutator 
{
	/////////////////////////////////////////////////////////////////
	// --------------------------------------------------- Properties
	/////////////////////////////////////////////////////////////////
	
	/** Generated by eclipse */
	
	private static final long serialVersionUID = -6151514191272182142L;

	/////////////////////////////////////////////////////////////////
	// ------------------------------------------------- Constructors
	/////////////////////////////////////////////////////////////////
	
	/**
	 * Empty constructor
	 */
	
	public RandomMutator() 
	{
		super();
	}

	/////////////////////////////////////////////////////////////////
	// ----------------------------------------------- Public methods
	/////////////////////////////////////////////////////////////////

	// java.lang.Object methods

	@Override
	public boolean equals(Object other)
	{
		if (other instanceof RandomMutator) {
			RandomMutator o = (RandomMutator) other;
			EqualsBuilder eb = new EqualsBuilder();
			eb.append(locusMutProb, o.locusMutProb);
			return eb.isEquals();
		}
		else {
			return false;
		}
	}	

	/////////////////////////////////////////////////////////////////
	// -------------------------------------------- Protected methods
	/////////////////////////////////////////////////////////////////

	// AbstractMutator methods

	/**
	 * {@inheritDoc}
	 */
	
	@Override
	protected void doLocusMutation(double[] parentChromosome, double[] mutantChromosome, int locusIndex) 
	{
		mutantChromosome[locusIndex] = 
			genotypeSchema[locusIndex].getRandom(randgen);		
	}

	/**
	 * {@inheritDoc}
	 */
	
	@Override
	protected double defaultLocusMutProb() 
	{
		return 0.6;
	}
}
	


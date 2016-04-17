package com.simukappu.coherence.distributed.fifo;

import java.util.function.Function;

/**
 * Function implementation class to distributed processing as First in, first
 * out.<br>
 * This function calls putIfAbsent-like method to coherence cache with a key and
 * then call process method only when the entry is first in.<br>
 * 
 * @author Shota Yamazaki
 */
public abstract class FifoDistributedFunction<T, R> implements
		FifoDistributedProcessor<T>, Function<T, R> {

	/**
	 * Target cache name to use as the key set for distributed processing
	 */
	String targetCacheName = null;

	/**
	 * Constructor with the target cache name
	 * 
	 * @param targetCacheName
	 *            Target cache name to use as the key set for distributed
	 *            processing
	 */
	public FifoDistributedFunction(String targetCacheName) {
		this.targetCacheName = targetCacheName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.simukappu.coherence.distributed.fifo.FifoDistributedProcessor#
	 * getTargetCacheName()
	 */
	@Override
	public String getTargetCacheName() {
		return this.targetCacheName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.function.Function#apply(java.lang.Object)
	 */
	@Override
	public R apply(T t) {
		if (this.invoke(t)) {
			return process(t);
		} else {
			return null;
		}
	}

	/**
	 * Processing function to be overridden.
	 * 
	 * @param t
	 *            The function argument
	 * @return Return value of the function
	 */
	abstract public R process(T t);

}
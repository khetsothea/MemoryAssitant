package com.boroborome.ma.model;

import java.util.Iterator;
import java.util.Set;

import com.boroborome.footstone.model.AbstractFilterIterator;

/**
 * @author boroborome
 *
 */
public class MAKeywordFilterIterator extends AbstractFilterIterator<MAKeyword>
{
	private Set<String> setExcludeKeyword;
	private Set<String> setAvailableKeyword;

	public MAKeywordFilterIterator(Iterator<MAKeyword> innerIt, Set<String> setExcludeKeyword, 
			Set<String> setAvailableKeyword)
	{
		super(innerIt);
		this.setExcludeKeyword = setExcludeKeyword == null || setExcludeKeyword.isEmpty() ? null : setExcludeKeyword;
		this.setAvailableKeyword = setAvailableKeyword == null || setAvailableKeyword.isEmpty() ? null : setAvailableKeyword;
	}
	
	@Override
	public boolean isMatch(MAKeyword value)
	{
		if (setExcludeKeyword != null && setExcludeKeyword.contains(value.getKeyword()))
		{
			return false;
		}
		if (setAvailableKeyword != null && !setAvailableKeyword.contains(value.getKeyword()))
		{
			return false;
		}
		return true;
	}
}

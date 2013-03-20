/*************************************************************************************
 * Copyright (c) 2008-2013 Red Hat, Inc. and others.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     JBoss by Red Hat - Initial implementation.
 ************************************************************************************/
package org.jboss.tools.central.internal.discovery;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.mylyn.internal.discovery.core.model.ValidationException;
import org.eclipse.osgi.util.NLS;
import org.jboss.tools.central.JBossCentralActivator;
import org.jboss.tools.central.internal.xpl.ExpressionResolutionException;
import org.jboss.tools.central.internal.xpl.ExpressionResolver;

/**
 * 
 * @author snjeza
 *
 */
public class DiscoveryConnector extends org.eclipse.mylyn.internal.discovery.core.model.DiscoveryConnector {

	@Override
	public void validate() throws ValidationException {
		try {
			siteUrl = ExpressionResolver.DEFAULT_RESOLVER.resolve(siteUrl);
			super.validate();
		} catch (ExpressionResolutionException e) {
			new ValidationException(NLS.bind("URL ''{0}'' use expression resolved with error: \"{1}\"", siteUrl,e.getMessage()));
		}
	}

}

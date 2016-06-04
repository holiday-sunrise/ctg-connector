package org.mule.modules.ctg.transaction;

import javax.resource.ResourceException;
import javax.resource.cci.Connection;
import javax.resource.cci.ConnectionFactory;

import org.mule.config.i18n.CoreMessages;
import org.mule.api.MuleContext;
import org.mule.api.transaction.TransactionException;
import org.mule.transaction.AbstractSingleResourceTransaction;
import org.mule.transaction.IllegalTransactionStateException;

public class CTGTransaction extends AbstractSingleResourceTransaction {

	private Connection connection;
	
	public CTGTransaction(MuleContext muleContext) {
		super(muleContext);
	}
	
	@Override
	public void bindResource(Object key, Object resource) throws TransactionException
	{
		if (!(key instanceof ConnectionFactory) || !(resource instanceof Connection)) {
			throw new IllegalTransactionStateException(
				CoreMessages.transactionCanOnlyBindToResources(
					"javax.resource.cci.ConnectionFactory/javax.resource.cci.Connection"));
		}
		
		setConnection((Connection) resource);
		
		super.bindResource(key, resource);
	}
	
	@Override
	protected void doBegin() throws TransactionException {
		// TODO Auto-generated method stub

		try {
			getConnection().getLocalTransaction().begin();
		} catch (ResourceException e) {
			throw new TransactionException(e);
		}
	}

	@Override
	protected void doCommit() throws TransactionException {
		// TODO Auto-generated method stub
		try {
			getConnection().getLocalTransaction().commit();
		} catch (ResourceException e) {
			throw new TransactionException(e);
		}
	}

	@Override
	protected void doRollback() throws TransactionException {
		// TODO Auto-generated method stub
		try {
			getConnection().getLocalTransaction().rollback();
		} catch (ResourceException e) {
			throw new TransactionException(e);
		}
	}

	protected Connection getConnection() {
		return connection;
	}

	protected void setConnection(Connection connection) {
		this.connection = connection;
	}

}

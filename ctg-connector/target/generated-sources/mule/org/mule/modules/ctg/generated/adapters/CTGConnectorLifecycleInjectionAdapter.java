
package org.mule.modules.ctg.generated.adapters;

import javax.annotation.Generated;
import org.mule.api.MuleContext;
import org.mule.api.MuleException;
import org.mule.api.context.MuleContextAware;
import org.mule.api.lifecycle.Disposable;
import org.mule.api.lifecycle.Initialisable;
import org.mule.api.lifecycle.InitialisationException;
import org.mule.api.lifecycle.Startable;
import org.mule.api.lifecycle.Stoppable;
import org.mule.common.MuleVersion;
import org.mule.config.MuleManifest;
import org.mule.config.i18n.CoreMessages;
import org.mule.modules.ctg.CTGConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * A <code>CTGConnectorLifecycleInjectionAdapter</code> is a wrapper around {@link CTGConnector } that adds lifecycle methods to the pojo. This adapter also allows the injection of several Mule facilities when a MuleContext is set.
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.8.0", date = "2016-06-06T12:17:29-04:00", comments = "Build UNNAMED.2762.e3b1307")
public class CTGConnectorLifecycleInjectionAdapter
    extends CTGConnectorMetadataAdapter
    implements MuleContextAware, Disposable, Initialisable, Startable, Stoppable
{


    @Override
    public void start()
        throws MuleException
    {
    }

    @Override
    public void stop()
        throws MuleException
    {
    }

    @Override
    public void initialise()
        throws InitialisationException
    {
        Logger log = LoggerFactory.getLogger(CTGConnectorLifecycleInjectionAdapter.class);
        MuleVersion connectorVersion = new MuleVersion("3.5.0");
        MuleVersion muleVersion = new MuleVersion(MuleManifest.getProductVersion());
        if (!muleVersion.atLeastBase(connectorVersion)) {
            throw new InitialisationException(CoreMessages.minMuleVersionNotMet(this.getMinMuleVersion()), this);
        }
        super.init();
    }

    @Override
    public void dispose() {
    }

    @Override
    public void setMuleContext(MuleContext context) {
        super.setMuleContext(context);
    }

}

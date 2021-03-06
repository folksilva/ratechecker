package ratechecker.server.guice;

import net.customware.gwt.dispatch.server.guice.ActionHandlerModule;

import org.apache.commons.logging.Log;

import ratechecker.server.handlers.CheckRateHandler;
import ratechecker.server.handlers.GetRatesHandler;
import ratechecker.server.handlers.RecentRatesCache;
import ratechecker.server.handlers.SaveRateHandler;

import com.google.appengine.api.memcache.MemcacheService;
import com.google.inject.Singleton;

public class GuiceServerModule extends ActionHandlerModule {

	public GuiceServerModule() {
	}

	@Override
	protected void configureHandlers() {
		bind(Log.class).toProvider(LogProvider.class).in(Singleton.class);
		bind(PersistenceManagerProvider.class).in(Singleton.class);
		bind(MemcacheService.class).toProvider(MemcacheServiceProvider.class).in(Singleton.class);
		bind(RecentRatesCache.class).in(Singleton.class);

		bindHandler(CheckRateHandler.class);
		bindHandler(SaveRateHandler.class);
		bindHandler(GetRatesHandler.class);
	}

}

package org.kie;

import org.kie.process.CorrelationKeyFactory;

public interface KieInternalServices {
    
    CorrelationKeyFactory newCorrelationKeyFactory();

    /**
     * A Factory for this KieServices
     */
    public static class Factory {
        private static KieInternalServices INSTANCE;

        static {
            try {                
                INSTANCE = ( KieInternalServices ) Class.forName( "org.kie.builder.impl.KieInternalServicesImpl" ).newInstance();
            } catch (Exception e) {
                throw new RuntimeException("Unable to instance KieServices", e);
            }
        }

        /**
         * Returns a reference to the KieServices singleton
         */
        public static KieInternalServices get() {
            return INSTANCE;
        }
    }
}

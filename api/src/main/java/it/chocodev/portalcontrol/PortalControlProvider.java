package it.chocodev.portalcontrol;

public final class PortalControlProvider {
    private static PortalControl instance;

    private PortalControlProvider() {
        throw new UnsupportedOperationException("PortalControlProvider cannot be instantiated");
    }

    public static PortalControl get() {
        PortalControl instance = PortalControlProvider.instance;
        if(instance == null) {
            throw new IllegalStateException("Instance should not be null");
        }
        return instance;
    }

    public static void register(PortalControl instance) {
        PortalControlProvider.instance = instance;
    }

    public static void unregister() {
        PortalControlProvider.instance = null;
    }

}

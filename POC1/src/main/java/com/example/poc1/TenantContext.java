package com.example.poc1;

public class TenantContext {
    public static final String Tenant_ID_key = "X-Tenant-id";
    private static final ThreadLocal<TenantContext> context = new ThreadLocal();
    public int tenantID;

//    public static void createContext(){
//        TenantContext internalContext = new TenantContext();
//        context.set(internalContext);
//    }

    public TenantContext(int tenantID) {
        this.tenantID = tenantID;
    }

    public static void createContext(int tenantID){
        if(tenantID<=0){
            throw new IllegalArgumentException("Id provided is invalid");
        }
        TenantContext internalContext = new TenantContext(tenantID);
        context.set(internalContext);
    }

    public static int getTenantID(){
        TenantContext internalContext = (TenantContext)context.get();
        return internalContext.tenantID;
    }
}

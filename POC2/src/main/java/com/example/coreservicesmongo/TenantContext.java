package com.example.coreservicesmongo;

public class TenantContext {
    public static final String Tenant_ID_Key = "X-Tenant-ID";
    private static final ThreadLocal<TenantContext> context = new ThreadLocal<>();
    public final int TenantID;
    private String mongoConnection = "mongodb+srv://prajwala:password_01@cluster0.pjopb.mongodb.net/ID?retryWrites=true&w=majority";


    public TenantContext(int tenantID) {
        TenantID = tenantID;
        mongoConnection = "mongodb+srv://prajwala:password_01@cluster0.pjopb.mongodb.net/ID?retryWrites=true&w=majority";
        mongoConnection = mongoConnection.replace("ID", String.valueOf(tenantID));
    }

    public static void createContext(int ID){
        if (ID <= 0){
            throw new IllegalArgumentException("Invalid");
        }
        TenantContext internalContext = new TenantContext(ID);
        context.set(internalContext);
    }

    public static int getTenantID(){
        TenantContext internalContext = context.get();
        return internalContext.TenantID;
    }

    public static TenantContext getContext(){
        return context.get();
    }


    public String getDBConnectionString(){
        TenantContext internalContext = context.get();
        return internalContext.mongoConnection;
    }

    public static void clear(){
        context.remove();
        System.out.println("After cleanup process: "+context.get());
    }

}

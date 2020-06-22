package com.sunanda.attendance_kotlin.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001fB%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u00a2\u0006\u0002\u0010\tJ\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u001c\u0010\u0016\u001a\u00020\u00172\n\u0010\u0018\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0015H\u0017J\u001c\u0010\u001a\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0015H\u0016J\u0010\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0015H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/sunanda/attendance_kotlin/adapter/NewTaskAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/sunanda/attendance_kotlin/adapter/NewTaskAdapter$MyViewHolder;", "activity", "Landroid/app/Activity;", "stringList", "Ljava/util/ArrayList;", "Lcom/sunanda/attendance_kotlin/model/NewTaskPojo;", "Lkotlin/collections/ArrayList;", "(Landroid/app/Activity;Ljava/util/ArrayList;)V", "getActivity$app_debug", "()Landroid/app/Activity;", "setActivity$app_debug", "(Landroid/app/Activity;)V", "databaseHandler", "Lcom/sunanda/attendance_kotlin/database/DatabaseHandler;", "getDatabaseHandler", "()Lcom/sunanda/attendance_kotlin/database/DatabaseHandler;", "setDatabaseHandler", "(Lcom/sunanda/attendance_kotlin/database/DatabaseHandler;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "showDialog", "MyViewHolder", "app_debug"})
public final class NewTaskAdapter extends android.support.v7.widget.RecyclerView.Adapter<com.sunanda.attendance_kotlin.adapter.NewTaskAdapter.MyViewHolder> {
    @org.jetbrains.annotations.NotNull()
    public com.sunanda.attendance_kotlin.database.DatabaseHandler databaseHandler;
    @org.jetbrains.annotations.NotNull()
    private android.app.Activity activity;
    private final java.util.ArrayList<com.sunanda.attendance_kotlin.model.NewTaskPojo> stringList = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.sunanda.attendance_kotlin.database.DatabaseHandler getDatabaseHandler() {
        return null;
    }
    
    public final void setDatabaseHandler(@org.jetbrains.annotations.NotNull()
    com.sunanda.attendance_kotlin.database.DatabaseHandler p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.sunanda.attendance_kotlin.adapter.NewTaskAdapter.MyViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @android.annotation.SuppressLint(value = {"SetTextI18n"})
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.sunanda.attendance_kotlin.adapter.NewTaskAdapter.MyViewHolder holder, int position) {
    }
    
    private final void showDialog(int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.Activity getActivity$app_debug() {
        return null;
    }
    
    public final void setActivity$app_debug(@org.jetbrains.annotations.NotNull()
    android.app.Activity p0) {
    }
    
    public NewTaskAdapter(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.sunanda.attendance_kotlin.model.NewTaskPojo> stringList) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0011\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\b\u00a8\u0006\u0013"}, d2 = {"Lcom/sunanda/attendance_kotlin/adapter/NewTaskAdapter$MyViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/sunanda/attendance_kotlin/adapter/NewTaskAdapter;Landroid/view/View;)V", "address", "Landroid/widget/TextView;", "getAddress", "()Landroid/widget/TextView;", "date", "getDate", "deleteData", "Landroid/widget/ImageView;", "getDeleteData", "()Landroid/widget/ImageView;", "editData", "getEditData", "task", "getTask", "app_debug"})
    public final class MyViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView address = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView date = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView task = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.ImageView editData = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.ImageView deleteData = null;
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getAddress() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getDate() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTask() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageView getEditData() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageView getDeleteData() {
            return null;
        }
        
        public MyViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View view) {
            super(null);
        }
    }
}
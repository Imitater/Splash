package com.mouqukeji.myvideo.viewmodel;

import android.app.Application;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;

public class MainViewModel extends BaseViewModel {
    public ObservableField<String> userNameet = new ObservableField<>("");
    public ObservableField<String> userNametv = new ObservableField<>("");

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

     public BindingCommand loginOnClickCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            userNametv.set("");
            userNameet.set("");
        }
    });
    public BindingCommand textChangeCommand = new BindingCommand(new BindingAction(){
        @Override
        public void call() {

        }
    });
 }

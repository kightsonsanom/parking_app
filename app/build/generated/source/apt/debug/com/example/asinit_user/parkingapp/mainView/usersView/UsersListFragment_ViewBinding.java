// Generated code from Butter Knife. Do not modify!
package com.example.asinit_user.parkingapp.mainView.usersView;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.TabLayout;
import android.view.View;
import android.widget.ListView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.asinit_user.parkingapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class UsersListFragment_ViewBinding implements Unbinder {
  private UsersListFragment target;

  @UiThread
  public UsersListFragment_ViewBinding(UsersListFragment target, View source) {
    this.target = target;

    target.usersListView = Utils.findRequiredViewAsType(source, R.id.users_list_view, "field 'usersListView'", ListView.class);
    target.tabLayout = Utils.findRequiredViewAsType(source, R.id.tab_layout, "field 'tabLayout'", TabLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    UsersListFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.usersListView = null;
    target.tabLayout = null;
  }
}

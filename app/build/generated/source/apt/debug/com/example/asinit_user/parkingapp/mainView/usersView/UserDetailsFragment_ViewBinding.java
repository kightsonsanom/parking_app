// Generated code from Butter Knife. Do not modify!
package com.example.asinit_user.parkingapp.mainView.usersView;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.asinit_user.parkingapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class UserDetailsFragment_ViewBinding implements Unbinder {
  private UserDetailsFragment target;

  @UiThread
  public UserDetailsFragment_ViewBinding(UserDetailsFragment target, View source) {
    this.target = target;

    target.usernameLabel = Utils.findRequiredViewAsType(source, R.id.username_label, "field 'usernameLabel'", TextView.class);
    target.usernameText = Utils.findRequiredViewAsType(source, R.id.username_text, "field 'usernameText'", TextView.class);
    target.passwordLabel = Utils.findRequiredViewAsType(source, R.id.password_label, "field 'passwordLabel'", TextView.class);
    target.passwordText = Utils.findRequiredViewAsType(source, R.id.password_text, "field 'passwordText'", TextView.class);
    target.firstnameLabel = Utils.findRequiredViewAsType(source, R.id.firstname_label, "field 'firstnameLabel'", TextView.class);
    target.firstnameText = Utils.findRequiredViewAsType(source, R.id.firstname_text, "field 'firstnameText'", TextView.class);
    target.lastnameLabel = Utils.findRequiredViewAsType(source, R.id.lastname_label, "field 'lastnameLabel'", TextView.class);
    target.lastnameText = Utils.findRequiredViewAsType(source, R.id.lastname_text, "field 'lastnameText'", TextView.class);
    target.emailLabel = Utils.findRequiredViewAsType(source, R.id.email_label, "field 'emailLabel'", TextView.class);
    target.emailText = Utils.findRequiredViewAsType(source, R.id.email_text, "field 'emailText'", TextView.class);
    target.platenrLabel = Utils.findRequiredViewAsType(source, R.id.platenr_label, "field 'platenrLabel'", TextView.class);
    target.platenrText = Utils.findRequiredViewAsType(source, R.id.platenr_text, "field 'platenrText'", TextView.class);
    target.acceptUser = Utils.findRequiredViewAsType(source, R.id.accept_user, "field 'acceptUser'", TextView.class);
    target.denyUser = Utils.findRequiredViewAsType(source, R.id.deny_user, "field 'denyUser'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    UserDetailsFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.usernameLabel = null;
    target.usernameText = null;
    target.passwordLabel = null;
    target.passwordText = null;
    target.firstnameLabel = null;
    target.firstnameText = null;
    target.lastnameLabel = null;
    target.lastnameText = null;
    target.emailLabel = null;
    target.emailText = null;
    target.platenrLabel = null;
    target.platenrText = null;
    target.acceptUser = null;
    target.denyUser = null;
  }
}

// Generated code from Butter Knife. Do not modify!
package com.example.asinit_user.parkingapp.mainView.usersView;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.asinit_user.parkingapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class UserDetailsFragment_ViewBinding implements Unbinder {
  private UserDetailsFragment target;

  private View view2131230726;

  private View view2131230779;

  @UiThread
  public UserDetailsFragment_ViewBinding(final UserDetailsFragment target, View source) {
    this.target = target;

    View view;
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
    view = Utils.findRequiredView(source, R.id.accept_user, "field 'acceptUser' and method 'onViewClicked'");
    target.acceptUser = Utils.castView(view, R.id.accept_user, "field 'acceptUser'", Button.class);
    view2131230726 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.deny_user, "field 'denyUser' and method 'onViewClicked'");
    target.denyUser = Utils.castView(view, R.id.deny_user, "field 'denyUser'", Button.class);
    view2131230779 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
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

    view2131230726.setOnClickListener(null);
    view2131230726 = null;
    view2131230779.setOnClickListener(null);
    view2131230779 = null;
  }
}

// Generated code from Butter Knife. Do not modify!
package com.example.asinit_user.parkingapp.login;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.asinit_user.parkingapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LoginActivity_ViewBinding implements Unbinder {
  private LoginActivity target;

  private View view2131361902;

  private View view2131361937;

  @UiThread
  public LoginActivity_ViewBinding(LoginActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public LoginActivity_ViewBinding(final LoginActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.login_button, "field 'loginButton' and method 'onViewClicked'");
    target.loginButton = Utils.castView(view, R.id.login_button, "field 'loginButton'", Button.class);
    view2131361902 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.register_button, "field 'registerButton' and method 'onViewClicked'");
    target.registerButton = Utils.castView(view, R.id.register_button, "field 'registerButton'", Button.class);
    view2131361937 = view;
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
    LoginActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.loginButton = null;
    target.registerButton = null;

    view2131361902.setOnClickListener(null);
    view2131361902 = null;
    view2131361937.setOnClickListener(null);
    view2131361937 = null;
  }
}

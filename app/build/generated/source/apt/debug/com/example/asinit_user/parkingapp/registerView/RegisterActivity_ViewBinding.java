// Generated code from Butter Knife. Do not modify!
package com.example.asinit_user.parkingapp.registerView;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.asinit_user.parkingapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class RegisterActivity_ViewBinding implements Unbinder {
  private RegisterActivity target;

  private View view2131230865;

  @UiThread
  public RegisterActivity_ViewBinding(RegisterActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public RegisterActivity_ViewBinding(final RegisterActivity target, View source) {
    this.target = target;

    View view;
    target.usernameEditText = Utils.findRequiredViewAsType(source, R.id.username_edit_text, "field 'usernameEditText'", TextInputEditText.class);
    target.emailEditText = Utils.findRequiredViewAsType(source, R.id.email_edit_text, "field 'emailEditText'", TextInputEditText.class);
    target.platenrEditText = Utils.findRequiredViewAsType(source, R.id.platenr_edit_text, "field 'platenrEditText'", TextInputEditText.class);
    target.adminCheckbox = Utils.findRequiredViewAsType(source, R.id.admin_checkbox, "field 'adminCheckbox'", CheckBox.class);
    view = Utils.findRequiredView(source, R.id.register_button, "field 'registerButton' and method 'onViewClicked'");
    target.registerButton = Utils.castView(view, R.id.register_button, "field 'registerButton'", Button.class);
    view2131230865 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
    target.firstnameEditText = Utils.findRequiredViewAsType(source, R.id.firstname_edit_text, "field 'firstnameEditText'", TextInputEditText.class);
    target.surnameEditText = Utils.findRequiredViewAsType(source, R.id.surname_edit_text, "field 'surnameEditText'", TextInputEditText.class);
    target.passwordEditText = Utils.findRequiredViewAsType(source, R.id.password_edit_text, "field 'passwordEditText'", TextInputEditText.class);
    target.emailInputLayout = Utils.findRequiredViewAsType(source, R.id.email_input_layout, "field 'emailInputLayout'", TextInputLayout.class);
    target.platenrInputLayout = Utils.findRequiredViewAsType(source, R.id.platenr_input_layout, "field 'platenrInputLayout'", TextInputLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    RegisterActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.usernameEditText = null;
    target.emailEditText = null;
    target.platenrEditText = null;
    target.adminCheckbox = null;
    target.registerButton = null;
    target.firstnameEditText = null;
    target.surnameEditText = null;
    target.passwordEditText = null;
    target.emailInputLayout = null;
    target.platenrInputLayout = null;

    view2131230865.setOnClickListener(null);
    view2131230865 = null;
  }
}

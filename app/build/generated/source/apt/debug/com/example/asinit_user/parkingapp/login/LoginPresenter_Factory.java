// Generated by dagger.internal.codegen.ComponentProcessor (https://google.github.io/dagger).
package com.example.asinit_user.parkingapp.login;

import android.content.Context;
import com.example.asinit_user.parkingapp.repository.Repository;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class LoginPresenter_Factory implements Factory<LoginPresenter> {
  private final Provider<Repository> repositoryProvider;

  private final Provider<Context> contextProvider;

  public LoginPresenter_Factory(
      Provider<Repository> repositoryProvider, Provider<Context> contextProvider) {
    this.repositoryProvider = repositoryProvider;
    this.contextProvider = contextProvider;
  }

  @Override
  public LoginPresenter get() {
    return new LoginPresenter(repositoryProvider.get(), contextProvider.get());
  }

  public static Factory<LoginPresenter> create(
      Provider<Repository> repositoryProvider, Provider<Context> contextProvider) {
    return new LoginPresenter_Factory(repositoryProvider, contextProvider);
  }
}

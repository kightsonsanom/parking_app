// Generated by dagger.internal.codegen.ComponentProcessor (https://google.github.io/dagger).
package com.example.asinit_user.parkingapp.di;

import android.app.Application;
import com.example.asinit_user.parkingapp.login.LoginPresenter;
import com.example.asinit_user.parkingapp.repository.Repository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class LoginActivityModule_ProvideLoginPresenterFactory
    implements Factory<LoginPresenter> {
  private final LoginActivityModule module;

  private final Provider<Repository> repositoryProvider;

  private final Provider<Application> applicationProvider;

  public LoginActivityModule_ProvideLoginPresenterFactory(
      LoginActivityModule module,
      Provider<Repository> repositoryProvider,
      Provider<Application> applicationProvider) {
    this.module = module;
    this.repositoryProvider = repositoryProvider;
    this.applicationProvider = applicationProvider;
  }

  @Override
  public LoginPresenter get() {
    return Preconditions.checkNotNull(
        module.provideLoginPresenter(repositoryProvider.get(), applicationProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<LoginPresenter> create(
      LoginActivityModule module,
      Provider<Repository> repositoryProvider,
      Provider<Application> applicationProvider) {
    return new LoginActivityModule_ProvideLoginPresenterFactory(
        module, repositoryProvider, applicationProvider);
  }

  public static LoginPresenter proxyProvideLoginPresenter(
      LoginActivityModule instance, Repository repository, Application application) {
    return instance.provideLoginPresenter(repository, application);
  }
}

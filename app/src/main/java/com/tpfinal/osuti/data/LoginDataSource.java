package com.tpfinal.osuti.data;

import com.tpfinal.osuti.data.model.LoggedInUser;
import com.tpfinal.osuti.models.Usuario;
import com.tpfinal.osuti.repository.AppRepository;

import java.io.IOException;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    public Result<LoggedInUser> login(String username, String password, AppRepository appRepository) {

        try {
            // TODO: handle loggedInUser authentication
            Usuario usuario = appRepository.buscarUsuario(username, password);
            LoggedInUser User =
                    new LoggedInUser(
                            usuario.getId().toString(),
                            usuario.getNombre() + " " + usuario.getApellido());

            return new Result.Success<>(User);
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }
}
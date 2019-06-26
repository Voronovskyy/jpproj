package LITS.jpproj.service;


public interface TokenService {
    Long parseToken(String token);

    String createToken(Integer id);
}

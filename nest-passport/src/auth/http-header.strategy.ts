import { Injectable, UnauthorizedException } from '@nestjs/common';
import { PassportStrategy } from '@nestjs/passport';
import { Strategy } from 'passport-http-header-strategy';
import { AuthService } from './auth.service';

@Injectable()
export class HttpHeaderStrategy extends PassportStrategy(Strategy) {
  constructor(private authService: AuthService) {
    super({ header: 'x-user-data' });
  }

  public validate(userData: string) {
    const user = this.authService.validateUser(userData);
    if (!user) {
      throw new UnauthorizedException();
    }
    return user;
  }
}

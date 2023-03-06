import { Injectable } from '@nestjs/common';

@Injectable()
export class AuthService {
  async validateUser(userData: string): Promise<any> {
    const user = JSON.parse(Buffer.from(userData, 'base64').toString());
    if (user) {
      return user;
    }
    return null;
  }
}

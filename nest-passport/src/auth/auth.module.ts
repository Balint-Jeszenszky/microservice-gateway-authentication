import { Module } from '@nestjs/common';
import { PassportModule } from '@nestjs/passport';
import { AuthService } from './auth.service';
import { HttpHeaderStrategy } from './http-header.strategy';

@Module({
  imports: [PassportModule],
  providers: [AuthService, HttpHeaderStrategy],
})
export class AuthModule {}

import { Controller, Request, UseGuards, Get } from '@nestjs/common';
import { HttpHeaderAuthGuard } from './auth/http-header-auth.guard';

@Controller()
export class AppController {
  @UseGuards(HttpHeaderAuthGuard)
  @Get('auth/user')
  async login(@Request() req) {
    return req.user;
  }
}

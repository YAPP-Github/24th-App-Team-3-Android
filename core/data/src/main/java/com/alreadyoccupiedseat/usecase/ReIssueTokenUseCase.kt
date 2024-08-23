package com.alreadyoccupiedseat.usecase

import com.alreadyoccupiedseat.data.login.LoginRepository
import javax.inject.Inject

class ReIssueTokenUseCase @Inject constructor(
    private val loginRepository: LoginRepository
) {
    suspend operator fun invoke() = loginRepository.reIssueToken()
}
/*
 * Copyright 2008 JRimum Project
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at http://www.apache.org/licenses/LICENSE-2.0 Unless required by
 * applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS
 * OF ANY KIND, either express or implied. See the License for the specific
 * language governing permissions and limitations under the License.
 * 
 * Created at: 30/03/2008 - 18:53:16
 * 
 * ================================================================================
 * 
 * Direitos autorais 2008 JRimum Project
 * 
 * Licenciado sob a Licença Apache, Versão 2.0 ("LICENÇA"); você não pode usar
 * esse arquivo exceto em conformidade com a esta LICENÇA. Você pode obter uma
 * cópia desta LICENÇA em http://www.apache.org/licenses/LICENSE-2.0 A menos que
 * haja exigência legal ou acordo por escrito, a distribuição de software sob
 * esta LICENÇA se dará “COMO ESTÁ”, SEM GARANTIAS OU CONDIÇÕES DE QUALQUER
 * TIPO, sejam expressas ou tácitas. Veja a LICENÇA para a redação específica a
 * reger permissões e limitações sob esta LICENÇA.
 * 
 * Criado em: 30/03/2008 - 18:53:16
 * 
 */


package org.jrimum.vallia.digitoverificador;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.jrimum.vallia.digitoverificador.AbstractDigitoVerificador;
import org.jrimum.vallia.digitoverificador.BoletoCodigoDeBarrasDV;
import org.junit.Before;
import org.junit.Test;

/**
 * Teste da classe <code>DV_Boleto_CódigoDeBarra</code>.
 * 
 * @author Gabriel Guimarães
 * @author Gilmar P.S.L
 * @author <a href="mailto:misaelbarreto@gmail.com">Misael Barreto</a>
 * @author <a href="mailto:romulomail@gmail.com">Rômulo Augusto</a>
 * @since 16/03/2007
 */
public class TestBoletoCodigoDeBarrasDV{

	private AbstractDigitoVerificador dv_Validator_CodigoDeBarra;

	@Before
	public void setUp() throws Exception {

		dv_Validator_CodigoDeBarra = new BoletoCodigoDeBarrasDV();
	}

	@Test
	public void testCalculeString() {

		try {

			dv_Validator_CodigoDeBarra.calcule(null);
			
			fail("IllegalArgumentException esperado não ocorreu.");
			assertTrue(false);

		} catch (IllegalArgumentException iaex) {

			assertTrue(true);
			System.out.println(iaex.getMessage());
		}

		try {
			
			dv_Validator_CodigoDeBarra.calcule("123456789");
			
			fail("IllegalArgumentException esperado não ocorreu.");
			assertTrue(false);

		} catch (IllegalArgumentException iaex) {

			assertTrue(true);
			System.out.println(iaex.getMessage());
		}

		try {
			
			dv_Validator_CodigoDeBarra.calcule("ABC123456789");
			
			fail("IllegalArgumentException esperado não ocorreu.");
			assertTrue(false);

		} catch (IllegalArgumentException iaex) {

			assertTrue(true);
			System.out.println(iaex.getMessage());
		}

		assertEquals(6, dv_Validator_CodigoDeBarra
				.calcule("1049300600000022061014044910000000020061732"));
	}

}
